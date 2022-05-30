package com.example.recipe1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeService {

    @GET("?{parameter}={input}")
    fun getSearchQ(@Path("parameter") parameter : String, @Path("input") input : String) : Call<List<RecipeInfo>>



}