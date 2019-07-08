package ru.vadimgrablev.madbrainspractise.view

import ru.vadimgrablev.madbrainspractise.model.Product
import com.arellomobile.mvp.MvpView

interface MainView : MvpView {

    fun setList(products: List<Product>)

}