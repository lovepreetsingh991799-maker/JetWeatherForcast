package com.noisefit.jetweatherforcast.repository

import com.noisefit.jetweatherforcast.data.WeatherDao
import com.noisefit.jetweatherforcast.model.Favorite
import com.noisefit.jetweatherforcast.model.Units
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDbRepository @Inject constructor(private val weatherDao: WeatherDao) {
    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)
    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavorite(favorite)
    suspend fun deleteAllFavorite() = weatherDao.deleteAllFavorites()
    suspend fun deleteFavorite(favorite: Favorite)= weatherDao.deleteFavorite(favorite)
    suspend fun getfavById(city: String): Favorite = weatherDao.getFavById(city)


    fun getUnit(): Flow<List<Units>> = weatherDao.getUnits()
    suspend fun insertUnit(unit: Units) = weatherDao.insertUnit(unit)
    suspend fun updateUnit(unit: Units) = weatherDao.updateUnit(unit)
    suspend fun deleteAllUnits() = weatherDao.deleteAllUnits()
    suspend fun deleteUnit(unit: Units) = weatherDao.deleteUnit(unit)


}