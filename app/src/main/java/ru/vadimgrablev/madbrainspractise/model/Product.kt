package ru.vadimgrablev.madbrainspractise.model

import io.realm.RealmObject
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
    var name: String,

    @SerializedName("price")
    @Expose
    val price: String,

    @SerializedName("count")
    @Expose
    val count: Int
){

    val product = ProductDB()

    init{
        product.name = this.name
        product.price = this.price
        product.count = this.count
    }

}

open class ProductDB : RealmObject() {

    lateinit var name: String
    lateinit var price: String
    var count: Int = 0
}
