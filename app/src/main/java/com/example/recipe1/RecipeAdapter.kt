package com.example.recipe1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.constraintlayout.widget.ConstraintLayout

class RecipeAdapter(var dataSet : List<RecipeInfo>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textViewTitle : TextView,
        val TextViewPic : Text
    }

}