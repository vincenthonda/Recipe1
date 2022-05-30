package com.example.recipe1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val homeButton = findViewById<ImageButton>(R.id.history_button_home)
        val bookmarkButton = findViewById<ImageButton>(R.id.history_button_bookmarks)


        homeButton.setOnClickListener {
            val historyIntent = Intent(this,HomeActivity::class.java)
            startActivity(historyIntent)
        }
        bookmarkButton.setOnClickListener {
            val bookmarkIntent = Intent(this,BookmarkActivity::class.java)
            startActivity(bookmarkIntent)
        }
    }
}