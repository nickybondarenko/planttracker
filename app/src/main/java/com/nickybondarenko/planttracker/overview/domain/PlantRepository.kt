package com.nickybondarenko.planttracker.overview.domain

interface PlantRepository {
  suspend fun getAllPlants(): List<Plant>
}