package com.example.recipe1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.recipe1.databinding.ActivityBookmarkBinding
import com.example.recipe1.databinding.ActivityHistoryBinding

class BookmarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookmarkBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val homeButton = findViewById<ImageButton>(R.id.bookmark_button_home)
        val historyButton = findViewById<ImageButton>(R.id.bookmark_button_history)


        homeButton.setOnClickListener {
            val historyIntent = Intent(this,HomeActivity::class.java)
            startActivity(historyIntent)
        }
        historyButton.setOnClickListener {
            val bookmarkIntent = Intent(this,HistoryActivity::class.java)
            startActivity(bookmarkIntent)
        }
    }
}