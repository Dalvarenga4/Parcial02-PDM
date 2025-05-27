package com.djah02.parcial02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.djah02.parcial02.ui.theme.Parcial02Theme
import com.djah02.parcial02.ui.navigation.BottomNavBar
import com.djah02.parcial02.ui.navigation.AppNavigation
import com.djah02.parcial02.viewmodel.ProductoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Parcial02Theme {
                val navController = rememberNavController()
                val productoViewModel: ProductoViewModel = viewModel()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val current = backStackEntry?.destination?.route ?: "menu"

                Scaffold(
                    bottomBar = {
                        if (!current.startsWith("details")) {
                            BottomNavBar(navController)
                        }
                    }
                ) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        AppNavigation(navController, productoViewModel)
                    }
                }
            }
        }
    }
}