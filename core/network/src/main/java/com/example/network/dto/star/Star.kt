package com.example.network.dto.star

data class Star(
    val memNo: Long,
    val nickNm: String,
    val roomNo: Int,
    val typeEntry: Int,
    val title: String,
    val roomType: String,
    val roomTypeNm: String,
    val profImg: ProfImg,
    val roomYn: String
)