package com.example.recipe1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class RecipeInfo(
    val title: String,
    val calories: String,
    val carbs: String,
    val fat: String,
    val protein: String,
    val image: String,
    val id: Int,
) : Parcelable {
}