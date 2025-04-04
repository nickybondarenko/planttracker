package com.nickybondarenko.planttracker.overview.di

import com.nickybondarenko.planttracker.overview.data.PlantRepositoryImpl
import com.nickybondarenko.planttracker.overview.data.PlantsAPI
import com.nickybondarenko.planttracker.overview.domain.PlantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApi() : PlantsAPI {
        return Retrofit.Builder().baseUrl("https://test.com").build().create(PlantsAPI::class.java)
    }

    @Provides
    fun providesPlantRepository(api: PlantsAPI): PlantRepository {
        return PlantRepositoryImpl(api)
    }
}