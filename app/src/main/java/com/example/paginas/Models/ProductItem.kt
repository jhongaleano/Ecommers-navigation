package com.example.paginas.Models

import kotlinx.serialization.Serializable

@Serializable
data class ProductItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: Int,
    val user: String
)

