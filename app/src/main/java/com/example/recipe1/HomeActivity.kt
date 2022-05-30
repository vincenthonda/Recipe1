package com.example.recipe1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.recipe1.databinding.ActivityHistoryBinding
import com.example.recipe1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    companion object {
        var searchQuery: String = "query"
        var searchEntry: String = "pie"
        var historyList = listOf<RecipeInfo>()
        var bookmarkList = listOf<RecipeInfo>()
    }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val languages = resources.getStringArray(R.array.search_array)
        val spinner = findViewById<Spinner>(R.id.home_spinner)
        val historyButton = findViewById<ImageButton>(R.id.home_button_history)
        val bookmarkButton = findViewById<ImageButton>(R.id.home_button_bookmarks)
        val searchButton = findViewById<Button>(R.id.home_button_search)
        val textbox = findViewById<SearchView>(R.id.searchView)


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
                    searchQuery = getString(R.string.selected_item)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


        searchButton.setOnClickListener {
            searchEntry = textbox.query as String
            val detailIntent = Intent(this,RecipeDetail::class.java)
            startActivity(detailIntent)
        }


        historyButton.setOnClickListener {
            val historyIntent = Intent(this,HistoryActivity::class.java)
            startActivity(historyIntent)
        }
        bookmarkButton.setOnClickListener {
            val bookmarkIntent = Intent(this,BookmarkActivity::class.java)
            startActivity(bookmarkIntent)
        }

        fun getSearchQuery(): String {
            return searchQuery
        }
        fun getSearchEntry(): String {
            return searchEntry
        }
    }
}