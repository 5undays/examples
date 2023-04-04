package com.example.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material.Snackbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.examples.databinding.ActivityMainBinding
import com.example.examples.ui.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

import com.google.android.material.snackbar.Snackbar;

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowsnackbar.setOnClickListener {
            viewModel.triggerEvent()
        }
        lifecycleScope.launch {
            viewModel.eventFlow.collect { event ->
                when (event) {
                    is MainViewModel.UiEvent.ErrorEvent -> {
                        Snackbar.make(binding.root, event.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
