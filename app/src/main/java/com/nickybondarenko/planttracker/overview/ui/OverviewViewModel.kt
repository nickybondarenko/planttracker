package com.nickybondarenko.planttracker.overview.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickybondarenko.planttracker.overview.domain.Plant
import com.nickybondarenko.planttracker.overview.domain.PlantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(val plantRepository: PlantRepository) : ViewModel() {

  private val _state = MutableStateFlow<OverviewState>(OverviewState.InitialState(true))
  val state: StateFlow<OverviewState> = _state

  fun onAddPlantClicked() {

  }

  fun loadData() {
    viewModelScope.launch {
      try {
        val plants = plantRepository.getAllPlants()
        _state.value = OverviewState.DataState(false, plants)
      } catch (e: Exception) {
        _state.value = OverviewState.ErrorState(false)
      }
    }
  }
}

sealed class OverviewState(open val isLoading: Boolean) {
  data class InitialState(override val isLoading: Boolean) : OverviewState(isLoading)
  object EmptyState : OverviewState(false)
  data class ErrorState(override val isLoading: Boolean) : OverviewState(isLoading)
  data class DataState(override val isLoading: Boolean, val plants: List<Plant>) : OverviewState(isLoading)
}