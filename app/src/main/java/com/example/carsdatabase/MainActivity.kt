package com.example.carsdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carsdatabase.carsDataBase.Car
import com.example.carsdatabase.carsDataBase.Cars
import com.example.carsdatabase.preferenceFragment.FilterActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var typeOfFilter: String
    private val adapter = RecAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAddCarActivity.setOnClickListener {
            val toAddCar = Intent(this, AddCarActivity::class.java)
            startActivity(toAddCar)
        }

        btFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {

        super.onResume()

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        // Get type of filter from fragment
        typeOfFilter = pref.getString("filter_preference_list", "").toString()
        Log.d("TAG", typeOfFilter)
        // Choose filter for database
        when (typeOfFilter) {
            "Name" -> setList { Cars.db.carDAO().getAllOrderByName() }
            "Year" -> setList { Cars.db.carDAO().getAllOrderByYear() }
            "Color" -> setList { Cars.db.carDAO().getAllOrderByColor() }
            else -> setList { Cars.db.carDAO().readCars() }
        }
    }

    private fun setList(cars: () -> List<Car>) {
        Thread {
            val list = cars()
            runOnUiThread {
                adapter.setCarsList(list)
                tvCarsCount.text = getString(R.string.cars_count, list.size)
            }
        }.start()
    }
}