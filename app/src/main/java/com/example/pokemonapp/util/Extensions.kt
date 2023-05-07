package com.example.pokemonapp.util

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.example.pokemonapp.R

fun ImageView.loadSvgImg(url: String) {

    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadSvgImg.context)) }.build()

    var lottieComposition =
        LottieCompositionFactory.fromAssetSync(this.context, "Lotti/pokemon_lotti_loader.json")

    val lottieDrawable = LottieDrawable().apply {
        composition = lottieComposition.value
        repeatCount = LottieDrawable.INFINITE
        playAnimation()
    }

    val request = ImageRequest.Builder(this.context).placeholder(lottieDrawable)
        .error(R.drawable.error_warning_line_icon).data(url).target(this).build()
    imageLoader.enqueue(request)
}