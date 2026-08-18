package com.noisefit.jetweatherforcast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.noisefit.jetweatherforcast.screens.about.AboutScreen
import com.noisefit.jetweatherforcast.screens.favourite.FavouriteScreen
import com.noisefit.jetweatherforcast.screens.main.MainScreen
import com.noisefit.jetweatherforcast.screens.main.MainViewModel
import com.noisefit.jetweatherforcast.screens.search.SearchScreen
import com.noisefit.jetweatherforcast.screens.setting.SettingsScreen
import com.noisefit.jetweatherforcast.screens.setting.SettingsViewModel
import com.noisefit.jetweatherforcast.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController,
    startDestination = WeatherScreens.SplashScreen.name){
        composable(WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(navController  = navController)
        }

        val route = WeatherScreens.MainScreen.name
        composable("$route/{city}",
            arguments = listOf(
                navArgument(name = "city"){
                    type = NavType.StringType
                }
            )) { navBack ->
            navBack.arguments?.getString("city").let {city ->

                val mainViewModel = hiltViewModel<MainViewModel>()
                val settingsViewModel = hiltViewModel<SettingsViewModel>()
                MainScreen(
                    navController = navController, mainViewModel,
                    settingsViewModel = settingsViewModel,
                    city = city)
            }

        }

        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController  = navController)
        }

        composable(WeatherScreens.AboutScreen.name) {
            AboutScreen(navController  = navController)
        }

        composable(WeatherScreens.FavoriteScreen.name) {
            FavouriteScreen(navController  = navController)
        }

        composable(WeatherScreens.SettingsScreen.name) {
            SettingsScreen(navController  = navController)
        }
    }
}