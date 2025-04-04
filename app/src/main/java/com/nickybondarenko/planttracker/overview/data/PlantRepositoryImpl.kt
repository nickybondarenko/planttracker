package com.nickybondarenko.planttracker.overview.data

import com.nickybondarenko.planttracker.overview.domain.Plant
import com.nickybondarenko.planttracker.overview.domain.PlantRepository
import javax.inject.Inject

class PlantRepositoryImpl @Inject constructor(
  private val api: PlantsAPI
) : PlantRepository {
  private var plants = mutableListOf(
    Plant(name = "Monstera", description = "Pretty"),
    Plant(name = "Palm tree", description = "Big"),
    Plant(name = "Peace lily", description = "About to die")
  )

  override suspend fun getAllPlantsFromBackup(): List<Plant> {
    return plants
  }

  override suspend fun getPlantsFromNetwork(): List<Plant> {
    api.getPlantsFromNetwork()
    return emptyList()
  }

  override suspend fun addPlant(plant: Plant) {
    plants.add(plant)
  }

  override suspend fun clear() {
    plants.clear()
  }
}