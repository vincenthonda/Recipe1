package com.example.recipe1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.recipe1.databinding.ActivityRecipeResultsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeResults : AppCompatActivity() {

    private lateinit var binding : ActivityRecipeResultsBinding
    val TAG = "RecipeResultsActvity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultsList = mutableListOf<RecipeInfo>()

        val historyButton = findViewById<ImageButton>(R.id.history_button_home)
        val homeButton = findViewById<ImageButton>(R.id.home_button_home)
        val bookmarkButton = findViewById<ImageButton>(R.id.history_button_bookmarks)

        historyButton.setOnClickListener {
            val historyIntent = Intent(this,HistoryActivity::class.java)
            startActivity(historyIntent)
        }
        homeButton.setOnClickListener {
            val historyIntent = Intent(this,HomeActivity::class.java)
            startActivity(historyIntent)
        }
        bookmarkButton.setOnClickListener {
            val bookmarkIntent = Intent(this,BookmarkActivity::class.java)
            startActivity(bookmarkIntent)
        }

        val recipeApi = RetrofitHelper.getInstance().create(RecipeService::class.java)
        val recipeCall = recipeApi.getSearchQ(HomeActivity.searchQuery, HomeActivity.searchEntry)

        recipeCall.enqueue(object : Callback<List<RecipeInfo>> {
            override fun onResponse(
                call: Call<List<RecipeInfo>>,
                response: Response<List<RecipeInfo>>,
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<List<RecipeInfo>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
    }
}