package com.example.recipe1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @GET("complexSearch")
    fun getSearchQ(@Query("query") query : String, @Query("apiKey") apiKey : String = "955b3eb646cb4d0b9337e3595bbbc4ca") : Call<List<RecipeItem>>

    //@GET("complexSearch/?{user_id}/playlists")
    //getUserPlaylists(@Path(value = "user_id", encoded = true) String userId): Call<List<RecipeInfo>

}