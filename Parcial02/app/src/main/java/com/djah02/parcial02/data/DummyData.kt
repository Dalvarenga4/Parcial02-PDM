package com.djah02.parcial02.data

import com.djah02.parcial02.model.Producto

object DummyData {
    fun getProducts(): List<Producto> {
        return listOf(
            Producto(
                id = 1,
                name = "Galleta",
                categories = listOf("Grasas, Azucar"),
                price = 3.50,
                imageUrl = "",
                descripcion = ""
            ),

            Producto(
                id = 2,
                name = "Jugo de Naranja",
                categories = listOf("Frutas, Jugos"),
                price = 4.99,
                imageUrl = "",
                descripcion = ""
            )
        )
    }

}