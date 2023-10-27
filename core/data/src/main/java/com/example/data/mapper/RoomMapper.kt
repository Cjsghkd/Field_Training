package com.example.data.mapper

import com.example.model.model.model.room.PageNoModel
import com.example.model.model.model.room.RoomListModel
import com.example.model.model.model.room.RoomModel
import com.example.network.dto.room.PageNo
import com.example.network.dto.room.Room
import com.example.network.dto.room.RoomList

internal fun PageNoModel.toPageNo() = PageNo(
    pageNo = pageNo
)

internal fun Room.toRoomModel() = RoomModel(
    roomTitle = roomTitle,
    bjProfileImage = bjProfileImage,
    teamMedalUrl = teamMedalUrl,
    bjNickName = bjNickName,
    dayLiveDjRank = dayLiveDjRank,
    countGood = countGood,
    countLiveMem = countLiveMem,
    bjMemSex = bjMemSex,
    typeMedia = typeMedia,
    toggle = null, // toggle 수정 필요?
    risingYn = risingYn
)

internal fun RoomList.toRoomListModel() = RoomListModel(
    RoomList = RoomList.map { it.toRoomModel() }
)