package ru.vadimgrablev.madbrainspractise.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vadimgrablev.madbrainspractise.R
import ru.vadimgrablev.madbrainspractise.R.*
import ru.vadimgrablev.madbrainspractise.model.Product


class DetailFragment : Fragment() {

    private val ARGUMENT_PAGE_NUMBER = "arg_page_number"

    private val KEY_NAME = "NAME"
    private val KEY_PRICE = "PRICE"
    private val KEY_COUNT = "COUNT"

    var pageNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageNumber = arguments!!.getInt(ARGUMENT_PAGE_NUMBER)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Создание View управляющей фрагментом
        val view = inflater.inflate(layout.fragment_detail, container, false)
        val nameTextView = view.findViewById<TextView>(R.id.detailNameId)
        val priceTextView = view.findViewById<TextView>(R.id.detailPriceId)
        val countTextView = view.findViewById<TextView>(R.id.detailCountId)

        // Получить и отобразить данные продукта из Bundle
        val args = arguments
        nameTextView.text = String.format("Наименование: %s", args!!.getString(KEY_NAME))
        priceTextView.text = String.format("Стоимость: %s", args.getString(KEY_PRICE))
        countTextView.text = String.format("Количество: %s шт.", args.getString(KEY_COUNT))

        return view
    }

    // Метод для создания экземпляра фрагмента
    fun newInstance(product: Product): DetailFragment {

        // Сохранение данных о продукте в Bundle-объекте
        val args = Bundle()
        args.putString(KEY_NAME, product.name)
        args.putString(KEY_PRICE, product.price)
        args.putString(KEY_COUNT, product.count.toString())

        // Создаем новый DetailFragment и отправляем Bundle как "arguments"
        val fragment = DetailFragment()
        fragment.arguments = args
        return fragment

    }

}
