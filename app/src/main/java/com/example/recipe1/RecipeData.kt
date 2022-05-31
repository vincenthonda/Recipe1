package com.example.recipe1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeData(
    val item : RecipeItem
) : Parcelable {

}
