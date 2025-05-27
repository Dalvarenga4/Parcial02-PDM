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
                imageUrl = "https://images.aws.nestle.recipes/resized/2020_06_03T13_20_43_mrs_ImageRecipes_146208lrg_1080_850.jpg",
                descripcion = "Galletas dulces con chispas de chocolate"
            ),

            Producto(
                id = 2,
                name = "Jugo de Naranja",
                categories = listOf("Frutas, Jugos"),
                price = 4.99,
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVI2oqpOgPel2iiagAtaKaczcvDl7TSMg6lw&s",
                descripcion = "Jugo natural de naranja saludable"
            )
        )
    }

}