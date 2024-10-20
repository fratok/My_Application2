package com.example.myapplication2

import kotlinx.serialization.Serializable

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

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

interface ItemApi{
    @GET("/JSON/shopping_list.json")
    fun getItem(): Call<ItemList>
}
val retrofit = Retrofit.Builder()
    .baseUrl("https://fratok.github.io/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val itemApi: ItemApi = retrofit.create(ItemApi::class.java)