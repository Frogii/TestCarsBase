package com.example.carsdatabase.carsDataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Car_DAO {

    @Insert
    fun saveCar(car: Car)

    @Query("SELECT * FROM Car")
    fun readCars(): List<Car>

    @Query("SELECT * FROM Car ORDER BY name ASC")
    fun getAllOrderByName(): List<Car>

    @Query("SELECT * FROM Car ORDER BY year ASC")
    fun getAllOrderByYear(): List<Car>

    @Query("SELECT * FROM Car ORDER BY color ASC")
    fun getAllOrderByColor(): List<Car>
}