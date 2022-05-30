package com.example.recipe1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class RecipeInfo(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
) : Parcelable {
}