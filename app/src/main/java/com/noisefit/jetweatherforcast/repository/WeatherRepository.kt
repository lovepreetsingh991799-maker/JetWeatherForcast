package com.noisefit.jetweatherforcast.repository

import com.noisefit.jetweatherforcast.data.DataOrException
import com.noisefit.jetweatherforcast.model.Weather
import com.noisefit.jetweatherforcast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String, units: String ): DataOrException<Weather, Boolean, Exception> {

        val response = try {
            api.getWeather(query = cityQuery, units = units)
        }catch (e: Exception){
            return DataOrException(e = e)
        }

        return DataOrException(data = response)

    }
}