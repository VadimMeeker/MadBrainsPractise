package ru.vadimgrablev.madbrainspractise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setText()

    }

    fun setText(){

        intent?.extras?.getString("PRODUCT_NAME_TAG").let{
            nameViewId_second.text = "Наименование: " + it
        }

        intent?.extras?.getString("PRODUCT_PRICE_TAG").let{
            priceViewId_second.text = "Цена: " + it + " рублей"
        }

        intent?.extras?.getString("PRODUCT_COUNT_TAG").let{
            countViewId_second.text = "Количество: " + it + " шт."
        }

    }

}