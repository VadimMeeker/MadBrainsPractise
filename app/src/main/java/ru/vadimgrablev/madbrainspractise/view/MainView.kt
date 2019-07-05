package ru.vadimgrablev.madbrainspractise.view

import com.arellomobile.mvp.MvpView
import ru.vadimgrablev.madbrainspractise.model.Product

interface MainView : MvpView {

    fun setList(products: List<Product>)

}