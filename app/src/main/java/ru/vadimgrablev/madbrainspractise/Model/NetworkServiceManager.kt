package ru.vadimgrablev.madbrainspractise.Model

interface NetworkServiceManager {

    fun sendRequestProductsToServer(unit: (List<Product>) -> Unit)
}