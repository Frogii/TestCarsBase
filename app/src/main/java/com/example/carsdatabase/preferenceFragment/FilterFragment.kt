package com.example.carsdatabase.preferenceFragment


import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.carsdatabase.R

class FilterFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.filter)
    }
}