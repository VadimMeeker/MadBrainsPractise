package ru.vadimgrablev.madbrainspractise.model

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    @GET("alegch/c1241c81e042d83c78caf38fc525ca04/raw/493b1b3dee02f4b896bd81096bdecaf5931c0332/products.json")

    fun getProducts(): Call<ResponseBody>
}