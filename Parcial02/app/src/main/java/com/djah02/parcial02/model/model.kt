package com.djah02.parcial02.model

data class Producto(
    val id: Int,
    val name: String,
    val categories: List<String>,
    val price: Double,
    val imageUrl: String,
    val descripcion: String
)