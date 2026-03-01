package com.example.countriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.countriesapp.ui.navigation.AppNav
import com.example.countriesapp.ui.theme.CountriesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesAppTheme {
                AppNav()
            }
        }
    }
}