package com.djah02.parcial02.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.djah02.parcial02.data.DummyData
import androidx.compose.material3.Text
import com.djah02.parcial02.model.Producto
import com.djah02.parcial02.ui.componets.ProductCard
import com.djah02.parcial02.viewmodel.ProductoViewModel

@Composable
fun MenuScreen(
    navController: NavController,
    productoViewModel: ProductoViewModel
) {
    val productos = DummyData.getProducts()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.padding(24.dp))

        Text(
            text = "Nuestra Despensa",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ProductoGrid(
            productos = productos,
            navController = navController,
            modifier = Modifier.weight(1f)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductoGrid(
    productos: List<Producto>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val sortedProductos = productos.sortedBy { it.id }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(sortedProductos) { producto ->
            ProductCard(producto) {
                navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("producto", producto)

                navController.navigate("details")
            }
        }
    }
}
