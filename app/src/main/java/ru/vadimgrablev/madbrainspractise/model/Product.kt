package ru.vadimgrablev.madbrainspractise.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Info(

    @SerializedName("products")
    @Expose
    val products: List<Product>

)

data class Product(

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("price")
    @Expose
    val price: String,

    @SerializedName("count")
    @Expose
    val count: Int
)

