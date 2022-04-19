package com.nickybondarenko.planttracker.overview.data

import com.nickybondarenko.planttracker.overview.domain.Plant
import com.nickybondarenko.planttracker.overview.domain.PlantRepository

class PlantRepositoryImp : PlantRepository {
  override suspend fun getAllPlants(): List<Plant> {
    return listOf(
      Plant(name = "Monstera", description = "Pretty"),
      Plant(name = "Palm tree", description = "Big"),
      Plant(name = "Peace lily", description = "About to die")
    )
  }
}