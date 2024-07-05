package com.example.swiggydeomo.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.swiggydeomo.ui.screen.DetailScreen
import com.example.swiggydeomo.ui.screen.HomeScreen


@Composable
fun AppNavigation() {
    
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = HomeScreenRoute ){
        composable<HomeScreenRoute> {
            HomeScreen(navController)
        }
        composable<DetailScreenRoute> {
            val args = it.toRoute<DetailScreenRoute>()
            DetailScreen(title = args.movieName, decription =args.description , imageUrl =args.imageUrl )
        }
        composable<ErrorPage> {
            Text(text = "Some Error has Occured")
        }
    }
}