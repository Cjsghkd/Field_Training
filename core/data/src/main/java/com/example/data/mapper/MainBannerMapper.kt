package com.example.data.mapper

import com.example.model.model.model.main_banner.MainBannerListModel
import com.example.model.model.model.main_banner.MainBannerModel
import com.example.network.dto.main_banner.MainBanner
import com.example.network.dto.main_banner.MainBannerList

internal fun MainBanner.toMainBannerModel() = MainBannerModel(
    thumbnailUrl = thumbnailUrl,
    mem_nick = mem_nick,
    title = title
)

internal fun MainBannerList.toMainBannerListModel() = MainBannerListModel(
    BannerList = BannerList.map { it.toMainBannerModel() }
)