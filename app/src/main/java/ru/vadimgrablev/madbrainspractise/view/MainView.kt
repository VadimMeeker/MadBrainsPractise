package ru.vadimgrablev.madbrainspractise.view

import com.arellomobile.mvp.MvpView
import ru.vadimgrablev.madbrainspractise.model.Product

interface MainView : MvpView {

    fun initRealm()

    fun setList(products: List<Product>)

}