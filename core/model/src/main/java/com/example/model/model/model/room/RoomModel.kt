package com.example.model.model.model.room

data class RoomModel(
    val roomTitle: String,
    val bjProfileImage: String,
    val teamMedalUrl: String? = null,
    val bjNickName: String,
    val dayLiveDjRank: Int,
    val countGood: Int,
    val countLiveMem: Int,
    val bjMemSex: String,
    val typeMedia: String,
    val toggle: Int? = null,
    val risingYn: String
)