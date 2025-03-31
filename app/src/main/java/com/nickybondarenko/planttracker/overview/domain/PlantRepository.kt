package com.nickybondarenko.planttracker.overview.domain

interface PlantRepository {
  suspend fun getAllPlants(): List<Plant>
  suspend fun getPlantsFromNetwork(): List<Plant>
}