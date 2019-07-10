package ru.vadimgrablev.madbrainspractise.view

import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.vadimgrablev.madbrainspractise.*
import ru.vadimgrablev.madbrainspractise.model.Product
import ru.vadimgrablev.madbrainspractise.presenter.MainPresenter
import io.realm.Realm
import io.realm.RealmConfiguration


class MainActivity : MainView, MvpAppCompatActivity() {

    // Аннотация для управления жизненным циклом Presenter
    @InjectPresenter
    lateinit var mMainPresenter: MainPresenter

    private var recylerViewState: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRealm()

        mMainPresenter.onCreate()

    }

    override fun onStop() {
        super.onStop()

        recylerViewState = recyclerViewId.layoutManager!!.onSaveInstanceState()

    }

    override fun onResume() {
        super.onResume()

        recyclerViewId.layoutManager!!.onRestoreInstanceState(recylerViewState)

    }



    // Отправляю список в RecyclerView
    override fun setList(products: List<Product>) {

        val adapter = ProductAdapter(products)
        recyclerViewId.adapter = adapter

        recyclerViewId.addItemDecoration(DividerItemDecoration(recyclerViewId.context, DividerItemDecoration.VERTICAL))

        // Определяет дополнительные параметры
        // LayoutManager отвечает за позиционирование view-компонентов в RecyclerView
        // LinearLayoutManager, который показывает данные в простом списке – вертикальном или горизонтальном
        val layoutManager = LinearLayoutManager(this)
        recyclerViewId.layoutManager = layoutManager
    }

    // функция инициализации Realm
    private fun initRealm(){
        Realm.init(this)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            // при изменении конфигурации, БД будет пересоздаваться
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }

}
