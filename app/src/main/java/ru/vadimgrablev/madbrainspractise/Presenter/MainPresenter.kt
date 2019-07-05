package ru.vadimgrablev.madbrainspractise.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.vadimgrablev.madbrainspractise.model.NetworkService
import ru.vadimgrablev.madbrainspractise.model.NetworkServiceManager
import ru.vadimgrablev.madbrainspractise.view.MainView

// Аннотация для привязывания ViewState к Presenter
@InjectViewState
class MainPresenter : PresenterManager, MvpPresenter<MainView>() {

    private var networkService: NetworkServiceManager = NetworkService()

    override fun onCreate() {
        networkService.sendRequestProductsToServer { viewState.setList(it) }
    }
}
