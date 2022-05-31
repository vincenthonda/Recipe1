package com.example.recipe1

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class RecipeInfo(
    @SerializedName("results")
    //val results : Array<RecipeItem>,

    val results: RecipeItem,
    val offset: Int,
    val numberDisplayed: Int,
    val totalResults: Int
) : Parcelable {
}

