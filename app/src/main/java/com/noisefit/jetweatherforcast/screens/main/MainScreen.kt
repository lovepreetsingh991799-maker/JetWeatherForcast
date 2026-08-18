package com.noisefit.jetweatherforcast.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.noisefit.jetweatherforcast.data.DataOrException
import com.noisefit.jetweatherforcast.model.Weather
import com.noisefit.jetweatherforcast.model.WeatherItem
import com.noisefit.jetweatherforcast.navigation.WeatherScreens
import com.noisefit.jetweatherforcast.screens.setting.SettingsViewModel
import com.noisefit.jetweatherforcast.uitls.formatDate
import com.noisefit.jetweatherforcast.uitls.formatDecimals
import com.noisefit.jetweatherforcast.widgets.HumidityWindPressureRow
import com.noisefit.jetweatherforcast.widgets.SunSetAndSunRice
import com.noisefit.jetweatherforcast.widgets.WeatherAppBar
import com.noisefit.jetweatherforcast.widgets.WeatherDetailRow
import com.noisefit.jetweatherforcast.widgets.WeatherStateImage
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
    settingsViewModel: SettingsViewModel,
    city: String?
){

    val curCity: String = if (city!!.isBlank()) "Seattle" else city

    val unitFromDb = settingsViewModel.unitList.collectAsState().value
    var unit by remember {
        mutableStateOf("imperial")
    }

    var isImperial by remember {
        mutableStateOf(false)
    }

    if (!unitFromDb.isNullOrEmpty()){

        unit = unitFromDb[0].unit.split(" ")[0].lowercase()
        isImperial = unit == "imperial"

        val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
            initialValue = DataOrException(loading = true),
            key1 = unit,
            key2 = curCity) {

            value = mainViewModel.getWeatherData(city = curCity,
            units = unit)

        }.value

        if(weatherData.loading == true){
            CircularProgressIndicator()
        }else if (weatherData.data != null){
            MainScaffold(weather = weatherData.data!!, navController = navController)
        }

    }


}

@Composable
fun MainScaffold(weather: Weather, navController: NavController){

    Scaffold(topBar = {
        WeatherAppBar(title = weather.city.name + " ,${weather.city.country}",
//            icon = Icons.Default.ArrowBack,
            navController = navController,
            onAddActionClick ={
                navController.navigate(WeatherScreens.SearchScreen.name)
            },
            elevation = 5.dp){
            Log.d("On Click", "MainScaffold: Button Click")
        }
    }) {
        MainContent(data = weather, modifier = Modifier.padding(it))
    }

}

@Composable
fun MainContent(data: Weather, modifier: Modifier = Modifier) {

    val weatherItem = data.list[0]

    val imageUrl = "https://openweathermap.org/img/wn/${data.list[0].weather[0].icon}.png"

    Column(Modifier.padding(top = 100.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = formatDate( data.list[0].dt),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primaryFixed,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp))

        Surface(modifier = Modifier.padding(4.dp).size(200.dp),
            shape = CircleShape,
            color = Color(0xFFFFFC400)
        ) {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                WeatherStateImage(imageUrl = imageUrl)
                Text(text = formatDecimals(weatherItem.temp.day)+ "°", style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.ExtraBold)


                Text(text = weatherItem.weather[0].main, fontStyle = FontStyle.Italic)
            }
        }
        HumidityWindPressureRow(weather = weatherItem)
        Divider()
        SunSetAndSunRice(weather = weatherItem)
        Text(text = "This Week",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold)

        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            color = Color(0xFFEEF1EF),
            shape = RoundedCornerShape(size = 14.dp)
            ) {
            LazyColumn(modifier = Modifier.padding(2.dp),
                contentPadding = PaddingValues(1.dp)
            ) {
                items(items = data.list){ item: WeatherItem ->
                    WeatherDetailRow(weather = item)

                }
            }
        }
    }

}

