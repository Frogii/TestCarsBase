package com.example.carsdatabase.carsDataBase

import androidx.room.Room
import com.example.carsdatabase.App

object Cars {
    var db: AppDB = Room.databaseBuilder(App.instance, AppDB::class.java, "CarsDB").build()
}

