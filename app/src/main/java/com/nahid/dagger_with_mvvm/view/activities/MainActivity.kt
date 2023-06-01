package com.nahid.dagger_with_mvvm.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nahid.dagger_with_mvvm.AppApplication
import com.nahid.dagger_with_mvvm.databinding.ActivityMainBinding
import com.nahid.dagger_with_mvvm.view_model.ProductViewModel
import com.nahid.dagger_with_mvvm.view_model.ProductViewModelFactory
import javax.inject.Inject

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productViewModel: ProductViewModel

    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as AppApplication).applicationComponent.inject(this)
        productViewModel =
            ViewModelProvider(this, productViewModelFactory)[ProductViewModel::class.java]


        productViewModel.productLiveData.observe(this) {
            binding.title = it.joinToString { data -> data.title + "\n\n" }
            Log.d(TAG, "onCreate: ${it.size}")
        }
    }
}