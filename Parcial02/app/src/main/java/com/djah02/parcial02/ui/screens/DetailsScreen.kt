package com.djah02.parcial02.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.djah02.parcial02.model.Producto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {
    val context = LocalContext.current

    val producto = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<Producto>("producto")

    if (producto == null) {
        Text("No se encontró ningún producto.")
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(producto.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = producto.imageUrl,
                contentDescription = producto.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Text("Nombre: ${producto.name}", style = MaterialTheme.typography.titleLarge)
            Text("Categoria: ${producto.categories.joinToString()}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))

            ProductoItem(producto) {
                Toast.makeText(context, "${producto.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                // Aquí puedes agregar la lógica para agregar al carrito
            }
        }
    }
}

@Composable
fun ProductoItem(producto: Producto, onAddClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(bottom = 12.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(producto.imageUrl),
                contentDescription = producto.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(producto.name, fontWeight = FontWeight.Bold)
                Text(producto.descripcion, style = MaterialTheme.typography.bodySmall)
            }
            Button(onClick = onAddClick, modifier = Modifier.padding(start = 8.dp)) {
                Text("Agregar")
            }
        }
    }
}
