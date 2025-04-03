package com.nickybondarenko.planttracker.overview.domain

interface PlantRepository {
  suspend fun getAllPlantsFromBackup(): List<Plant>
  suspend fun getPlantsFromNetwork(): List<Plant>
  fun clear()
}