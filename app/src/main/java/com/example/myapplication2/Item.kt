package com.example.myapplication2

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val id: Int,
    val image: String,
    val name: String,
    val description: String,
    val additionalInfo1: String,
    val additionalInfo2: String,
    val price: Int
)
@Serializable
data class ItemList(
    val list: List<Item>
)



