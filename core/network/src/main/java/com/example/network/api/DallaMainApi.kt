package com.example.network.api

import com.example.network.dto.ad_banner.AdBannerList
import com.example.network.dto.main_banner.MainBannerList
import com.example.network.dto.room.PageNo
import com.example.network.dto.room.RoomList
import com.example.network.dto.star.StarList
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DallaMainApi {
    @POST("RqRoomList")
    suspend fun postRoomList(
        @Body pageNo: PageNo
    ): RoomList

    @GET("RqBannerList")
    suspend fun getMainBannerList(): MainBannerList

    @GET("RqEventBannerList")
    suspend fun getAdBannerList(): AdBannerList

    @GET("RqMyStarList")
    suspend fun getStarList(): StarList
}