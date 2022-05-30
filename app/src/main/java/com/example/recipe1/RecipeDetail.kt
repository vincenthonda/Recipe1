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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val homeButton = findViewById<ImageButton>(R.id.detail_imageButton_home)
        val id : Int = 980
        val imageUrl: String = "https://api.spoonacular.com/recipes/"+ id +"/card"

        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        homeButton.setOnClickListener {
            val homeIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeIntent)
        }


        Picasso.get().load(imageUrl).into(binding.detailImageView)
    }
}