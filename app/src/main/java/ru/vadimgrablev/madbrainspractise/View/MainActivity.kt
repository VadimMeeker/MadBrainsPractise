package ru.vadimgrablev.madbrainspractise.View

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.vadimgrablev.madbrainspractise.*
import ru.vadimgrablev.madbrainspractise.Model.Product
import ru.vadimgrablev.madbrainspractise.Presenter.MainPresenter


class MainActivity : MainView, MvpAppCompatActivity() {

    // Аннотация для управления жизненным циклом Presenter
    @InjectPresenter
    lateinit var mMainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainPresenter.onCreate()

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

}
