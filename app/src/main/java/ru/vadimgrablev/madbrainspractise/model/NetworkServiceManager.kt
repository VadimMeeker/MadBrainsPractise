package ru.vadimgrablev.madbrainspractise.model

interface NetworkServiceManager {

    fun sendRequestProductsToServer(unit: (List<Product>) -> Unit)
}