package com.example.myapplication2

import kotlinx.serialization.Serializable

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
@Serializable
data class Item(
    val id: Int,
    val image: String,
    val name: String,
    val description: String,
    val additionalInfo1: String,
    val additionalInfo2: String,
    val price: Int,
    val imageUrl: String
)
@Serializable
data class ItemList(
    val list: List<Item>
)

