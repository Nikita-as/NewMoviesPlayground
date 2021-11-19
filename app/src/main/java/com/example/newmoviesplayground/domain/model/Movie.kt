package com.example.newmoviesplayground.domain.model

data class Movie(
    val id: Int?,
    val image: Image?,
    val name: String?,
    val rating: Rating?,
    val url: String?
)