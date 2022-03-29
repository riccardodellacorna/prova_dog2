package com.example.prova_dog

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val dogService: DogService) {
    suspend fun getDog() =
        dogService.getDog()
}