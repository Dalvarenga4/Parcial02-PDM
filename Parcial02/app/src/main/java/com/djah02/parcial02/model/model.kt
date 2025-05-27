package com.djah02.parcial02.model

import java.io.Serializable

data class Producto(
    val id: Int,
    val name: String,
    val categories: List<String>,
    val price: Double,
    val imageUrl: String,
    val descripcion: String
) : Serializable