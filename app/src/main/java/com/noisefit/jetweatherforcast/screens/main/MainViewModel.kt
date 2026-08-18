package com.noisefit.jetweatherforcast.screens.main

import androidx.lifecycle.ViewModel
import com.noisefit.jetweatherforcast.data.DataOrException
import com.noisefit.jetweatherforcast.model.Weather
import com.noisefit.jetweatherforcast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository)
    : ViewModel(){
    suspend fun getWeatherData(city: String, units: String)
    : DataOrException<Weather, Boolean, Exception>{
        return repository.getWeather( cityQuery = city, units = units)
    }


}