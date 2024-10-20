package com.example.myapplication2

import kotlinx.serialization.Serializable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
    suspend fun getItem(): Response<ItemList>
}
private val retrofit = Retrofit.Builder()
    .baseUrl("https://fratok.github.io/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val itemApi: ItemApi = retrofit.create(ItemApi::class.java)

suspend fun fetchItems() {
    val response = withContext(Dispatchers.IO) {
        itemApi.getItem()
    }

    if (response.isSuccessful) {
        val itemList = response.body()
        itemList?.let {
            updateUiWithItems(it.list)
            }
        } else {
        val errorCode = response.code()
        when (errorCode) {
            404 -> showError("Страница не найдена")
            500 -> showError("Ошибка сервера, попробуйте позже")
            else -> showError("Неизвестная ошибка: $errorCode")
        }
    }
}
fun updateUiWithItems(items: List<Item>) {
}

fun showError(message: String) {
}


