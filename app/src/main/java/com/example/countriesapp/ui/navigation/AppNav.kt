package com.example.countriesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.countriesapp.ui.screens.countries.CountriesScreen
import com.example.countriesapp.ui.screens.detail.CountryDetailScreen

object Routes {
    const val COUNTRIES = "countries"
    const val DETAIL = "detail"
}

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.COUNTRIES) {
        composable(Routes.COUNTRIES) {
            CountriesScreen(
                onCountryClick = { code ->
                    navController.navigate("${Routes.DETAIL}/$code")
                }
            )
        }

        composable(
            route = "${Routes.DETAIL}/{code}",
            arguments = listOf(navArgument("code") { type = NavType.StringType })
        ) { backStackEntry ->
            val code = backStackEntry.arguments?.getString("code") ?: ""
            CountryDetailScreen(
                code = code,
                onBack = { navController.popBackStack() }
            )
        }
    }
}