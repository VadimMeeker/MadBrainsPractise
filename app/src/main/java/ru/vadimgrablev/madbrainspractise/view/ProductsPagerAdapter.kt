package ru.vadimgrablev.madbrainspractise.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import ru.vadimgrablev.madbrainspractise.model.Product


class ProductsPagerAdapter(fragmentManager: FragmentManager, val products: List<Product>) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return DetailFragment().newInstance(products[position])
    }

    override fun getCount(): Int {
        return products.size
    }
}