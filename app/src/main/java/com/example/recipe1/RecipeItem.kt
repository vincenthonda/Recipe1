package com.example.recipe1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeItem(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
) : Parcelable {
}