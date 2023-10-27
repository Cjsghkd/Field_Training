package com.example.data.mapper

import com.example.model.model.model.ad_banner.AdBannerListModel
import com.example.model.model.model.ad_banner.AdBannerModel
import com.example.network.dto.ad_banner.AdBanner
import com.example.network.dto.ad_banner.AdBannerList

internal fun AdBanner.toAdBannerModel() = AdBannerModel(
    bannerUrl = bannerUrl
)

internal fun AdBannerList.toAdBannerListModel() = AdBannerListModel(
    BannerList = BannerList.map { it.toAdBannerModel() }
)