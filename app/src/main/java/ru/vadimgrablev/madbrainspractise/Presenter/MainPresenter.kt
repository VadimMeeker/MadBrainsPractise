package ru.vadimgrablev.madbrainspractise.Presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.vadimgrablev.madbrainspractise.Model.NetworkService
import ru.vadimgrablev.madbrainspractise.Model.NetworkServiceManager
import ru.vadimgrablev.madbrainspractise.Model.Product
import ru.vadimgrablev.madbrainspractise.View.MainView

// Аннотация для привязывания ViewState к Presenter
@InjectViewState
class MainPresenter : PresenterManager, MvpPresenter<MainView>() {

    private var networkService: NetworkServiceManager = NetworkService()

    override fun onCreate() {
        networkService.sendRequestProductsToServer {viewState.setList(it)}
    }
}
