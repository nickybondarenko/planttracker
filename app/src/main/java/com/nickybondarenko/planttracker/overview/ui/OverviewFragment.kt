package com.nickybondarenko.planttracker.overview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.nickybondarenko.planttracker.R
import com.nickybondarenko.planttracker.databinding.FragmentOverviewBinding
import com.nickybondarenko.planttracker.databinding.ViewEmptyPlantListBinding
import com.nickybondarenko.planttracker.exhaustive
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OverviewFragment : Fragment() {

  private var _binding: FragmentOverviewBinding? = null
  private val binding get() = _binding!!
  private val viewModel: OverviewViewModel by viewModels()
  private var snackbar: Snackbar? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentOverviewBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupButtonListener()
    observeState()
    viewModel.loadData()
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

  private fun observeState() {
    lifecycleScope.launch {
      viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collectLatest {
        handleLoading(it)
        binding.includedEmptyPlantList.viewEmptyPlantList.visibility = GONE
        snackbar?.dismiss()
        when (it) {
          // DataState is successful loading of data
            // Feed the data from view model into recycler view here, recycler view to display data in the app
          is OverviewState.DataState -> TODO()
          // EmptyState means that the database loaded, but there was no data
          is OverviewState.EmptyState -> {
            binding.includedEmptyPlantList.viewEmptyPlantList.visibility = VISIBLE
          }
          is OverviewState.ErrorState -> {
            if (snackbar == null) {
              snackbar = Snackbar.make(binding.root, R.string.unknown_error, Snackbar.LENGTH_INDEFINITE).setAction(R.string.generic_retry, object:View.OnClickListener {
                override fun onClick(v: View?) {
                  viewModel.loadData()
                }
              })
            }
            snackbar?.show()
          }
          // InitialState just shows loading
          is OverviewState.InitialState -> {
          }
        }.exhaustive
      }
    }
  }

  private fun handleLoading(overviewState: OverviewState) {
    if (overviewState.isLoading) {
      binding.loading.visibility = VISIBLE
    } else {
      binding.loading.visibility = GONE
    }
  }
}