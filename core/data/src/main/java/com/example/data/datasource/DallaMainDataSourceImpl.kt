package com.example.data.datasource

import com.example.network.dto.ad_banner.AdBannerList
import com.example.network.dto.main_banner.MainBannerList
import com.example.network.dto.room.PageNo
import com.example.network.dto.room.RoomList
import com.example.network.dto.star.StarList
import com.example.network.api.DallaMainApi
import javax.inject.Inject

internal class DallaMainDataSourceImpl @Inject constructor(
    private val dallaMainApi: DallaMainApi
): DallaMainDataSource {
    override suspend fun postRoomList(pageNo: PageNo): RoomList =
        dallaMainApi.postRoomList(pageNo)

    override suspend fun getMainBannerList(): MainBannerList =
        dallaMainApi.getMainBannerList()

    override suspend fun getAdBannerList(): AdBannerList =
        dallaMainApi.getAdBannerList()

    override suspend fun getStarList(): StarList =
        dallaMainApi.getStarList()
}