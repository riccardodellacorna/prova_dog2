package com.example.prova_dog

import retrofit2.Response
import retrofit2.http.GET

interface DogService {
    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse> //function that can be paused and resumed at a later time
}