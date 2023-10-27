package com.example.data.datasource

import com.example.network.dto.ad_banner.AdBannerList
import com.example.network.dto.main_banner.MainBannerList
import com.example.network.dto.room.PageNo
import com.example.network.dto.room.RoomList
import com.example.network.dto.star.StarList

internal interface DallaMainDataSource {
    suspend fun postRoomList(pageNo: PageNo): RoomList

    suspend fun getMainBannerList(): MainBannerList

    suspend fun getAdBannerList(): AdBannerList

    suspend fun getStarList(): StarList
}