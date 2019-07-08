package ru.vadimgrablev.madbrainspractise.model

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkService : NetworkServiceManager {

    var products: List<Product> = mutableListOf()
    lateinit var unit: (List<Product>) -> Unit

    // Получение экземпляра класса API
    private fun getApi(): ProductApi {
        val retrofit: Retrofit = Retrofit.Builder()
            // Базовая часть адреса
            .baseUrl("https://gist.githubusercontent.com")
            .build()

        // Указываем какой интерфейс используется для построения API
        val api: ProductApi = retrofit.create(ProductApi::class.java)
        return api
    }

    // Парсинг JSON  в List Products
    private fun parseResponse(responseText: String?): List<Product> {

        val gson = GsonBuilder().setPrettyPrinting().create()

        var productInfo: Info = gson.fromJson(responseText, Info::class.java)
        return productInfo.products
    }

    // Обработчик результата выполнения запроса
    private val callback: Callback<ResponseBody> = object : Callback<ResponseBody> {

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            val responseText: String? = response.body()?.string()
            Log.d("responseTag", responseText)
            products = parseResponse(responseText)
            unit.invoke(products)
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            t.printStackTrace()
        }

    }

    override fun sendRequestProductsToServer(unit: (List<Product>) -> Unit) {
        this.unit = unit
        getApi().getProducts().enqueue(callback)
    }

}