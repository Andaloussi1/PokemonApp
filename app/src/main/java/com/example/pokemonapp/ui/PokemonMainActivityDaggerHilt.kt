package com.example.pokemonapp.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokemonMainActivityDaggerHilt :Application() {
    override fun onCreate() {
        super.onCreate()
    }
}