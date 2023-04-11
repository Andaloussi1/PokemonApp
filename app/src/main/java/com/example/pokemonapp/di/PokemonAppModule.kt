package com.example.pokemonapp.di

import com.example.pokemonapp.data.dataSource.PokemonRemoteDataSource
import com.example.pokemonapp.data.dataSource.PokemonRemoteDataSourceImpl
import com.example.pokemonapp.data.repository.PokemonRepository
import com.example.pokemonapp.data.repository.PokemonRepositoryImpl
import com.example.pokemonapp.network.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PokemonAppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonRepository =
        PokemonRepositoryImpl(pokemonRemoteDataSource)

}


@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object PokemonDataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(pokemonApiService: PokemonApiService): PokemonRemoteDataSource =
        PokemonRemoteDataSourceImpl(pokemonApiService)
}


