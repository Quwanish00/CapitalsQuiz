package com.example.capitalquizapp

import androidx.annotation.DrawableRes

data class Question(
    val id:Int,
    @DrawableRes val question: Int,
    val answers:List<String>,
    val correctAnswerId:Int

)


