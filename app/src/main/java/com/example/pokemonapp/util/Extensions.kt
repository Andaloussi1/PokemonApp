package com.example.pokemonapp.util

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.pokemonapp.R

fun ImageView.loadSvgImg(url: String) {

    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadSvgImg.context)) }.build()

    val request = ImageRequest.Builder(this.context).placeholder(R.drawable.loading_icon)
        .error(R.drawable.error_warning_line_icon).data(url).target(this).build()
    imageLoader.enqueue(request)
}