package com.djah02.parcial02.viewmodel

import androidx.lifecycle.ViewModel
import com.djah02.parcial02.model.Producto
import androidx.compose.runtime.mutableStateListOf


class ProductoViewModel : ViewModel() {
    private val _carrito = mutableStateListOf<Producto>()
    val carrito: List<Producto> = _carrito

    fun agregar(producto: Producto) {
        _carrito.add(producto)
    }

    fun quitar(producto: Producto) {
        _carrito.remove(producto)
    }

    fun limpiar() {
        _carrito.clear()
    }
}
