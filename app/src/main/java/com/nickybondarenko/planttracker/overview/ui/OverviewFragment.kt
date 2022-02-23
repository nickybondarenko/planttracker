package com.nickybondarenko.planttracker.overview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.nickybondarenko.planttracker.databinding.FragmentOverviewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OverviewFragment: Fragment() {

  private var _binding: FragmentOverviewBinding? = null
  private val binding get() = _binding!!
  private val viewModel: OverviewViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentOverviewBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupButtonListener()
    lifecycleScope.launch {
    viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collectLatest {
      when (it) {
        is OverviewState.DataState -> TODO()
        is OverviewState.EmptyState -> TODO()
        is OverviewState.ErrorState -> TODO()
        is OverviewState.InitialState -> {
          if (it.isLoading) {
            binding.loading.visibility = View.VISIBLE
          } else {
            binding.loading.visibility = View.GONE
          }

        }
      }
    }
  }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun setupButtonListener() {
    binding.addPlantButton.setOnClickListener {
      viewModel.onAddPlantClicked()
    }
  }
}