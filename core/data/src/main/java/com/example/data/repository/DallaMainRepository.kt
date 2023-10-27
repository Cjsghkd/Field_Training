package com.example.data.repository

import com.example.model.model.model.ad_banner.AdBannerListModel
import com.example.model.model.model.main_banner.MainBannerListModel
import com.example.model.model.model.room.PageNoModel
import com.example.model.model.model.room.RoomListModel
import com.example.model.model.model.star.StarListModel

interface DallaMainRepository {
    suspend fun postRoomList(pageNo: PageNoModel): RoomListModel

    suspend fun getMainBannerList(): MainBannerListModel

    suspend fun getAdBannerList(): AdBannerListModel

    suspend fun getStarList(): StarListModel
}