package com.example.carsdatabase.carsDataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(Car::class)], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun carDAO(): Car_DAO
}