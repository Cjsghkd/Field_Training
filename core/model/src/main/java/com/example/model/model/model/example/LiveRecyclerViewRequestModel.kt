package com.example.model.model.model.example

data class LiveRecyclerViewRequestModel(
    val background: Int,
    val gender: Int,
    val heart: Int,
    val rank: Int? = null,
    val miniIcon: Int? = null,
    val toggle: Int? = null,
    val medal: Int? = null,
    val title: String,
    val name: String,
    val peopleCount: String,
    val heartCount: String,
    val isBooster: Boolean
)
