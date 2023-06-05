package com.nahid.dagger_with_mvvm.view.activities

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nahid.dagger_with_mvvm.AppApplication
import com.nahid.dagger_with_mvvm.databinding.ActivityMainBinding
import com.nahid.dagger_with_mvvm.view.adapter.ProductAdapter
import com.nahid.dagger_with_mvvm.view_model.ProductViewModel
import com.nahid.dagger_with_mvvm.view_model.ProductViewModelFactory
import javax.inject.Inject

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    private lateinit var progressDialog: ProgressDialog

    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProgressDialog()
        (application as AppApplication).applicationComponent.inject(this)
        productViewModel =
            ViewModelProvider(this, productViewModelFactory)[ProductViewModel::class.java]
        productAdapter = ProductAdapter()
        binding.recyclerView.apply {
            layoutManager =
                GridLayoutManager(this@MainActivity, 2)
            adapter = productAdapter
        }
        productViewModel.productLiveData.observe(this) {
            if (it.isNotEmpty()) {
                it?.let {
                    progressDialog.show()
                    productViewModel.insertLocalDB(it)
                }
            }
        }

        productViewModel.productList.observe(this) {
            it?.let {
                productAdapter.setProduct(it)
                progressDialog.dismiss()
            }
        }
    }

    private fun initProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait...")
        progressDialog.setCancelable(false)
    }
}