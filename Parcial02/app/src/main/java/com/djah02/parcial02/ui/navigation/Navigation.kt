package com.djah02.parcial02.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.djah02.parcial02.ui.screens.DetailScreen
import com.djah02.parcial02.ui.screens.MenuScreen
import com.djah02.parcial02.ui.screens.OrderScreen
import com.djah02.parcial02.ui.screens.SearchScreen
import com.djah02.parcial02.viewmodel.ProductoViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    productoViewModel: ProductoViewModel
) {
    NavHost(navController, startDestination = "menu") {
        composable("menu") {
            MenuScreen(navController, productoViewModel)
        }
        composable("search") {
            SearchScreen(navController)
        }
        composable("details") {
            DetailScreen(navController, productoViewModel)
        }
        composable("order") {
            OrderScreen(navController, productoViewModel)
        }
    }
}
