package com.nickybondarenko.planttracker.overview.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor() : ViewModel() {

  private val _state = MutableStateFlow<OverviewState>(OverviewState.InitialState(true))
  val state: StateFlow<OverviewState> = _state

  fun onAddPlantClicked() {

  }
}

sealed class OverviewState {
  data class InitialState(val isLoading: Boolean): OverviewState()
  data class EmptyState(val isLoading: Boolean): OverviewState()
  data class ErrorState(val isLoading: Boolean): OverviewState()
  data class DataState(val isLoading: Boolean): OverviewState()
}