package com.nahid.dagger_with_mvvm.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nahid.dagger_with_mvvm.databinding.RowProductItemBinding
import com.nahid.dagger_with_mvvm.model.data.Products

private const val TAG = "ProductAdapter"
class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private var productList = listOf<Products>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ProductAdapter.ProductHolder {
        val view = RowProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductHolder, position: Int) {
        holder.binding(productList[position])
        Log.d(TAG, "onBindViewHolder: ${productList.size}")
    }

    override fun getItemCount(): Int = productList.size

    fun setProduct(productList: List<Products>) {
        this.productList = productList
        notifyDataSetChanged()
    }

    inner class ProductHolder(private val binding: RowProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(products: Products) {
            binding.product = products
        }

    }
}