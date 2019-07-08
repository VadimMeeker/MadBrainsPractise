package ru.vadimgrablev.madbrainspractise.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import ru.vadimgrablev.madbrainspractise.R
import ru.vadimgrablev.madbrainspractise.model.Product

// элемент списка
 class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView: TextView = itemView.findViewById(R.id.textViewId)
        private val countView: TextView = itemView.findViewById(R.id.countViewId)

        fun bind(product: Product) {
            textView.text = product.name // загружаем текст в TextView
            countView.text = product.count.toString() // загружаем текст в CountView

            itemView.setOnClickListener {
                openDetailActivity(itemView.context, product.name, product.price, product.count.toString())
            }
        }

        fun openDetailActivity(context: Context, ProductName: String, ProductPrice: String, ProductCount: String) {
            // создаем объект Intent для запуска текущей Activity
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("PRODUCT_NAME_TAG", ProductName)
            intent.putExtra("PRODUCT_PRICE_TAG", ProductPrice)
            intent.putExtra("PRODUCT_COUNT_TAG", ProductCount)
            // запускаем Activity
            context.startActivity(intent)
        }

 }

// адаптер - управляет элементами
class ProductAdapter(private val Products: List<Product>) : RecyclerView.Adapter<ProductsViewHolder>() {


    // Создает новый объект ViewHolder всякий раз, когда RecyclerView нуждается в этом.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val rootView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.product_item, parent, false)

        return ProductsViewHolder(rootView)
    }

    // Возвращает общее количество элементов списка
    override fun getItemCount(): Int {
        return Products.size
    }

    // Принимает объект ViewHolder и устанавливает необходимые данные для соответствующей строки во view-компоненте
    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(Products[position])
    }
}