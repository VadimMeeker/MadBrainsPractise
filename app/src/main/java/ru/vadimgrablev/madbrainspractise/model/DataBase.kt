package ru.vadimgrablev.madbrainspractise.model

import io.realm.Realm
import io.realm.RealmConfiguration
import ru.vadimgrablev.madbrainspractise.view.MainActivity

class DataBase : DataBaseManager {

    private var mActivity: MainActivity = MainActivity()


    // сохранение загруэенных фактов о котах в БД
    override fun saveIntoDB(products: List<Product>) {

        // получаем ссылку на БД
        val realm:Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        // сохраняем список продуктов в БД в транзакции
        realm.copyToRealm(getProductDB(products))
        realm.commitTransaction()
    }


    // чтение из БД
    override fun loadFromDB():List<Product>{
        // получаем ссылку на БД
        val realm: Realm = Realm.getDefaultInstance()
        return getProduct(realm.where(ProductDB::class.java).findAll())
    }

    // Перевод из ProductBD в Product
    private fun getProduct(list: List<ProductDB>): List<Product> {

        var updateList: MutableList<Product> = mutableListOf()

        list.forEach {
            val nameToReplace = it.name
            val priceToReplace = it.price
            val countToReplace = it.count

            val product = Product(nameToReplace, priceToReplace, countToReplace)

            updateList.add(product)
        }

        return updateList
    }

    // Перевод из ProductBD в Product
    private fun getProductDB(list: List<Product>): List<ProductDB> {

        var updateList: MutableList<ProductDB> = mutableListOf()

        list.forEach {
            val nameToReplace = it.name
            val priceToReplace = it.price
            val countToReplace = it.count

            val product = Product(nameToReplace, priceToReplace, countToReplace).product

            updateList.add(product)
        }

        return updateList
    }
}
