package com.example.pokemonapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("pokemonImgUrl")
fun bindImage(imgView: ImageView, imgUrl: String) {
    imgView.loadSvgImg(imgUrl)
}

