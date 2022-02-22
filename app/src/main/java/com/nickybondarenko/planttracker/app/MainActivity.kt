package com.nickybondarenko.planttracker.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nickybondarenko.planttracker.R
import com.nickybondarenko.planttracker.overview.ui.OverviewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
//    supportFragmentManager.beginTransaction()
//      .replace(R.id.container, OverviewFragment.getInstance()).commit()
  }
}