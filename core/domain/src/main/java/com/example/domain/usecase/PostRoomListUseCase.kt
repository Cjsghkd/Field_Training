package com.example.domain.usecase

import com.example.data.repository.DallaMainRepository
import com.example.model.model.model.room.PageNoModel
import javax.inject.Inject

class PostRoomListUseCase @Inject constructor(
    private val dallaMainRepository: DallaMainRepository
) {
    suspend operator fun invoke(pageNo: PageNoModel) = kotlin.runCatching {
        dallaMainRepository.postRoomList(pageNo)
    }
}