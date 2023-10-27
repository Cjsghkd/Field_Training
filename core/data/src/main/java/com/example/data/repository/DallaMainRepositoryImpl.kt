package com.example.data.repository

import com.example.data.datasource.DallaMainDataSource
import com.example.data.mapper.toAdBannerListModel
import com.example.data.mapper.toMainBannerListModel
import com.example.data.mapper.toPageNo
import com.example.data.mapper.toRoomListModel
import com.example.data.mapper.toStarListModel
import com.example.model.model.model.ad_banner.AdBannerListModel
import com.example.model.model.model.main_banner.MainBannerListModel
import com.example.model.model.model.room.PageNoModel
import com.example.model.model.model.room.RoomListModel
import com.example.model.model.model.star.StarListModel
import com.example.network.dto.ad_banner.AdBannerList
import com.example.network.dto.main_banner.MainBannerList
import com.example.network.dto.room.PageNo
import com.example.network.dto.room.RoomList
import com.example.network.dto.star.StarList
import javax.inject.Inject

internal class DallaMainRepositoryImpl @Inject constructor(
    private val dallaMainDataSource: DallaMainDataSource
): DallaMainRepository {
    override suspend fun postRoomList(pageNo: PageNoModel): RoomListModel =
        dallaMainDataSource.postRoomList(pageNo.toPageNo()).toRoomListModel()

    override suspend fun getMainBannerList(): MainBannerListModel =
        dallaMainDataSource.getMainBannerList().toMainBannerListModel()

    override suspend fun getAdBannerList(): AdBannerListModel =
        dallaMainDataSource.getAdBannerList().toAdBannerListModel()

    override suspend fun getStarList(): StarListModel =
        dallaMainDataSource.getStarList().toStarListModel()
}