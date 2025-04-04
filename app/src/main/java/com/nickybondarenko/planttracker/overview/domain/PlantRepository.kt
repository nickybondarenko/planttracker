package com.nickybondarenko.planttracker.overview.domain

interface PlantRepository {
  suspend fun getAllPlantsFromBackup(): List<Plant>
  suspend fun getPlantsFromNetwork(): List<Plant>
  suspend fun addPlant(plant: Plant)
  suspend fun clear()
}