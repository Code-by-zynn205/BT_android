package com.example.coffeeapp

data class Review(
    val reviewerName: String,
    val reviewText: String,
    val rating: Float,
    val date: String = "",
    val avatarRes: Int = 0
)

