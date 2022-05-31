package com.example.recipe1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso

class RecipeAdapter(var dataSet: List<RecipeItem>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textViewTitle : TextView
        val imageViewPic : ImageView
        val textViewID : TextView
        val layout : ConstraintLayout

        init {
            textViewTitle = view.findViewById(R.id.item_textView_title)
            textViewID = view.findViewById(R.id.item_textView_id)
            imageViewPic = view.findViewById(R.id.item_imageView)
            layout = view.findViewById(R.id.item_ConstraintLayout)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recipe, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val recipe = dataSet[position]


        viewHolder.textViewTitle.text = recipe.title
        viewHolder.textViewID.text = recipe.id.toString()
        Picasso.get().load(recipe.image).into(viewHolder.imageViewPic)

        viewHolder.layout.setOnClickListener {
            //Toast.makeText(it.context, "Hi, you clicked on ${vaccination.name}", Toast.LENGTH_SHORT).show()
            val context = viewHolder.layout.context
            val recipeDetailIntent = Intent(context, RecipeDetail::class.java).apply{
                putExtra(RecipeDetail.EXTRA_RECIPE, recipe)
            }
            //HomeActivity.historyList.add(recipe)
            context.startActivity(recipeDetailIntent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}

//private fun <E> MutableList<E>.add(element: RecipeItem) {}
