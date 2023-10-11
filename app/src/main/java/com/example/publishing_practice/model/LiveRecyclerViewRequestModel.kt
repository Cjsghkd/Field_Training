package com.example.publishing_practice.model

data class LiveRecyclerViewRequestModel(
    val background: Int,
    val gender: Int,
    val heart: Int,
    val rank: Int? = null,
    val miniIcon: Int? = null,
    val title: String,
    val name: String,
    val peopleCount: String,
    val heartCount: String
)
