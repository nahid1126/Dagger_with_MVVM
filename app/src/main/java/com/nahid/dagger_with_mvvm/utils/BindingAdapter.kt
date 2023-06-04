package com.nahid.dagger_with_mvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImageFromUrl(image: String) {
    var imageUrl = image
    this.load(imageUrl)
}