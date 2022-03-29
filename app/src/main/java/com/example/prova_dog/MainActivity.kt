package com.example.prova_dog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import coil.transform.RoundedCornersTransformation
import com.example.prova_dog.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        fetchData()
    }

    private fun fetchData() {
        mainViewModel.fetchDogResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    // bind data to the view

                    /*_binding.imgDog.load(
                        response.data.message
                    ) {
                        transformations(RoundedCornersTransformation(16f))
                    }*/
                }
                is NetworkResult.Error -> {
                    // show error message
                }
                is NetworkResult.Loading -> {
                    // show a progress bar
                }
            }
        }
    }

    private fun fetchResponse() {
        //mainViewModel.fetchDogResponse()
        //binding.pbDog.visibility = View.VISIBLE
    }
}