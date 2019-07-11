package ru.vadimgrablev.madbrainspractise.presenter


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.vadimgrablev.madbrainspractise.model.DataBase
import ru.vadimgrablev.madbrainspractise.model.DataBaseManager
import ru.vadimgrablev.madbrainspractise.model.NetworkService
import ru.vadimgrablev.madbrainspractise.model.NetworkServiceManager
import ru.vadimgrablev.madbrainspractise.view.MainView

// Аннотация для привязывания ViewState к Presenter
@InjectViewState
class MainPresenter : PresenterManager, MvpPresenter<MainView>() {

    private var networkService: NetworkServiceManager = NetworkService()
    private var dataBase: DataBaseManager = DataBase()


    override fun onCreate() {

        val listProduct = dataBase.loadFromDB()

        if (listProduct.isEmpty()) {
            networkService.sendRequestProductsToServer {
                dataBase.saveIntoDB(it)
                viewState.setList(it)
            }
        } else {
            viewState.setList(listProduct)
        }

    }
}
