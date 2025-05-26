package com.djah02.parcial02.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val current = navBackStackEntry?.destination?.route ?: "menu"

    NavigationBar {
        NavigationBarItem(
            selected = current.startsWith("menu"),
            onClick = { navController.navigate("menu") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Productos") },
            label = { Text("Productos") }
        )
        NavigationBarItem(
            selected = current.startsWith("search"),
            onClick = { navController.navigate("search") },
            icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            label = { Text("Buscar") }
        )
        NavigationBarItem(
            selected = current.startsWith("order"),
            onClick = { navController.navigate("order") },
            icon = { Icon(Icons.Default.List, contentDescription = "Carrito") },
            label = { Text("Carrito") }
        )
    }
}