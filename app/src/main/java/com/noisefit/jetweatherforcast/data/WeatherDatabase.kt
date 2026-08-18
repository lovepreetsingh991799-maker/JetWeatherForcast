package com.noisefit.jetweatherforcast.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noisefit.jetweatherforcast.model.Favorite
import com.noisefit.jetweatherforcast.model.Units

@Database(entities = [Favorite::class, Units::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}