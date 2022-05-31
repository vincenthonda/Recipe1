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
    val TAG = "RecipeResultsActivity"
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var recipeList = mutableListOf<RecipeItem>()


        adapter = RecipeAdapter(recipeList)

        //val resultsList = mutableListOf<RecipeInfo>()

        val historyButton = findViewById<ImageButton>(R.id.results_button_home)
        val homeButton = findViewById<ImageButton>(R.id.results_button_home)
        val bookmarkButton = findViewById<ImageButton>(R.id.results_button_bookmarks)

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

        val query = HomeActivity.searchQuery
        val entry = HomeActivity.searchEntry
        val recipeApi = RetrofitHelper.getInstance().create(RecipeService::class.java)
        var recipeCall = recipeApi.getSearchQ(HomeActivity.searchEntry)
        //recipeCall[0]
        //Log.d(TAG, recipeApi.getSearchQ("chicken parm").toString() + recipeCall.toString())

        //if(query=="Recipe") {
        //    recipeCall = recipeApi.getSearchQ(HomeActivity.searchEntry)
        //} else {
        //    recipeCall = recipeApi.getSearchQ(HomeActivity.searchEntry)
        //}
        recipeCall.enqueue(object : Callback<List<RecipeItem>> {
            override fun onResponse(
                call: Call<List<RecipeItem>>,
                response: Response<List<RecipeItem>>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
                recipeList = ((response.body()?.first() ?: listOf<RecipeItem>()) as MutableList<RecipeItem>)
                adapter = RecipeAdapter(recipeList)
                binding.resultsRecyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<RecipeItem>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
    }
}
