package com.example.carsdatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carsdatabase.carsDataBase.Car
import com.example.carsdatabase.carsDataBase.Cars
import kotlinx.android.synthetic.main.activity_add_car.*

class AddCarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        val name = etCarName.text
        val year = etCarYear.text
        val color = etCarColor.text

        btAddNewCar.setOnClickListener {

            if (etCarName.text.isEmpty() || etCarYear.text.isEmpty() || etCarColor.text.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val car = Car()
            car.year = year.toString().toInt()
            car.name = name.toString()
            car.color = color.toString()

            etCarName.text.clear()
            etCarYear.text.clear()
            etCarColor.text.clear()

            Thread {
                Cars.db.carDAO().saveCar(car)
            }.start()
            Toast.makeText(this, "Сar ${car.name} added in database", Toast.LENGTH_SHORT).show()
        }
    }
}