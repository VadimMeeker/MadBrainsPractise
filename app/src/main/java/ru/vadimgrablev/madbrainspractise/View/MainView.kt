package ru.vadimgrablev.madbrainspractise.View

import com.arellomobile.mvp.MvpView
import ru.vadimgrablev.madbrainspractise.Model.Product

interface MainView : MvpView {

    fun setList(products: List<Product>)

}