package ru.vadimgrablev.madbrainspractise.view

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import ru.vadimgrablev.madbrainspractise.R
import ru.vadimgrablev.madbrainspractise.model.DataBase
import ru.vadimgrablev.madbrainspractise.model.DataBaseManager


class DetailActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: ProductsPagerAdapter

    private var dataBase: DataBaseManager = DataBase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Кнопка <- на ActionBar
        assert(supportActionBar != null)   //null check
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)   //show back button

        // Получаем список продуктов из Базы Данных
        val products = dataBase.loadFromDB()

        viewPager = findViewById(R.id.viewPager)

        pagerAdapter = ProductsPagerAdapter(supportFragmentManager, products)
        viewPager.adapter = pagerAdapter


        viewPager.currentItem = intent?.extras?.getInt("PRODUCT_POSITION_TAG")!!.toInt()

    }

    // Функция для <- ActionBar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}