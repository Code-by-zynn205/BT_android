package com.example.coffeeapp
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("detail/{coffeeName}/{price}") { backStackEntry ->
            val coffeeName = backStackEntry.arguments?.getString("coffeeName") ?: ""
            val price = backStackEntry.arguments?.getString("price") ?: ""
            CoffeeDetailScreen(coffeeName, price)
        }
    }
}