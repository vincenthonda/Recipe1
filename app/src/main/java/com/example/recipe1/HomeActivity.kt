package com.example.recipe1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val languages = resources.getStringArray(R.array.search_array)
        val spinner = findViewById<Spinner>(R.id.home_spinner)
        val historyButton = findViewById<ImageButton>(R.id.home_button_history)
        val bookmarkButton = findViewById<ImageButton>(R.id.home_button_bookmarks)


        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@HomeActivity,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


        historyButton.setOnClickListener {
            val historyIntent = Intent(this,HistoryActivity::class.java)
            startActivity(historyIntent)
        }
        bookmarkButton.setOnClickListener {
            val bookmarkIntent = Intent(this,BookmarkActivity::class.java)
            startActivity(bookmarkIntent)
        }
    }
}