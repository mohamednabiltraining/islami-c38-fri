package com.route.IslamiC38Fri.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hadeth(
    val title: String,
    val content: String
) : Parcelable