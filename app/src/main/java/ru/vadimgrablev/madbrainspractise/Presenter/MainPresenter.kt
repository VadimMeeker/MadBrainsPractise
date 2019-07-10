package ru.vadimgrablev.madbrainspractise.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.vadimgrablev.madbrainspractise.model.*
import ru.vadimgrablev.madbrainspractise.view.MainView

// Аннотация для привязывания ViewState к Presenter
@InjectViewState
class MainPresenter : PresenterManager, MvpPresenter<MainView>() {

    private var networkService: NetworkServiceManager = NetworkService()
    private var dataBase: DataBaseManager = DataBase()


    override fun onCreate() {


        dataBase.loadFromDB().ifEmpty {
            networkService.sendRequestProductsToServer { dataBase.saveIntoDB(it) }

            viewState.setList(dataBase.loadFromDB())
        }

        viewState.setList(dataBase.loadFromDB())

    }

}
