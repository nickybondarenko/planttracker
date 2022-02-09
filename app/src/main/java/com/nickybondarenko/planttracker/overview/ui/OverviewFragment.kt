package com.nickybondarenko.planttracker.overview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nickybondarenko.planttracker.R

class OverviewFragment: Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_overview, null)
  }

  companion object {
    fun getInstance(): OverviewFragment {
      return OverviewFragment()
    }
  }
}