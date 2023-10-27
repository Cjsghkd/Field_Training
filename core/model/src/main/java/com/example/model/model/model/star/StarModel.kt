package com.example.model.model.model.star

import com.example.ui.R

data class StarModel(
    val nickNm: String?,
    val profImg: ProfImgModel,
    val count: String? = null,
    var background: Int? = R.drawable.online_bj_background,
    var whiteBackground: Int? = R.drawable.white_bj_background
)