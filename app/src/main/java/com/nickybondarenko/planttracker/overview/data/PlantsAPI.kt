package com.nickybondarenko.planttracker.overview.data

import retrofit2.http.GET

interface PlantsAPI {

    @GET("test")
    suspend fun getPlantsFromNetwork() {

    }
}