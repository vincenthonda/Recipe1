package com.example.recipe1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.example.recipe1.databinding.ActivityRecipeDetailBinding
import com.squareup.picasso.Picasso

class RecipeDetail : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeDetailBinding

    companion object {
        val EXTRA_RECIPE = "The recipe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recipeItem = intent.getParcelableExtra<RecipeItem>(EXTRA_RECIPE)

        val homeButton = findViewById<ImageButton>(R.id.detail_imageButton_home)

        homeButton.setOnClickListener {
            val homeIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeIntent)
        }


        Picasso.get().load("https://api.spoonacular.com/recipes/" + recipeItem?.id.toString() +"/card").into(binding.detailImageView)
    }
}