package ru.vadimgrablev.madbrainspractise.model

interface DataBaseManager {

    fun saveIntoDB(products: List<Product>)

    fun loadFromDB():List<Product>

}