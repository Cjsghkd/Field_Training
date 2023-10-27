package com.example.data.mapper

import com.example.model.model.model.star.ProfImgModel
import com.example.model.model.model.star.StarListModel
import com.example.model.model.model.star.StarModel
import com.example.network.dto.star.ProfImg
import com.example.network.dto.star.Star
import com.example.network.dto.star.StarList

internal fun ProfImg.toProfImgModel() = ProfImgModel(
    url = url
)

internal fun Star.toStarModel() = StarModel(
    nickNm = nickNm,
    profImg = profImg.toProfImgModel()
)

internal fun StarList.toStarListModel() = StarListModel(
    StarList = StarList.map { it.toStarModel() }
)