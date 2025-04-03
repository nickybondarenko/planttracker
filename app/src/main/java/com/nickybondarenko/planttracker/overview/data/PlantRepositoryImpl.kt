package com.nickybondarenko.planttracker.overview.data

import com.nickybondarenko.planttracker.overview.domain.Plant
import com.nickybondarenko.planttracker.overview.domain.PlantRepository
import javax.inject.Inject

class PlantRepositoryImpl @Inject constructor(
  val api: PlantsAPI
) : PlantRepository {
  var plants = mutableListOf<Plant>()
  override suspend fun getAllPlantsFromBackup(): List<Plant> {
    plants.add(Plant(name = "Monstera", description = "Pretty"))
    plants.add(Plant(name = "Palm tree", description = "Big"))
    plants.add(Plant(name = "Peace lily", description = "About to die"))
    return plants
  }

  override suspend fun getPlantsFromNetwork(): List<Plant> {
    api.getPlantsFromNetwork()
    return emptyList()
  }

  override fun clear() {
    plants.clear()
  }
}