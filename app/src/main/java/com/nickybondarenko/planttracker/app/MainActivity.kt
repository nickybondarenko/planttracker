package com.nickybondarenko.planttracker.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nickybondarenko.planttracker.R
import com.nickybondarenko.planttracker.databinding.ActivityMainBinding
import com.nickybondarenko.planttracker.overview.ui.OverviewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}