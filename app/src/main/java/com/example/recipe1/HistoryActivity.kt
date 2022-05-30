package com.example.recipe1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.recipe1.databinding.ActivityHistoryBinding
import com.example.recipe1.databinding.ActivityRecipeDetailBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val homeButton = findViewById<ImageButton>(R.id.history_button_home)
        val bookmarkButton = findViewById<ImageButton>(R.id.history_button_bookmarks)


        homeButton.setOnClickListener {
            val homeIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeIntent)
        }
        bookmarkButton.setOnClickListener {
            val bookmarkIntent = Intent(this,BookmarkActivity::class.java)
            startActivity(bookmarkIntent)
        }
    }
}