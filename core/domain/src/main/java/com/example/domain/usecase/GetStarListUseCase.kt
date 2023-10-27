package com.example.domain.usecase

import com.example.data.repository.DallaMainRepository
import javax.inject.Inject

class GetStarListUseCase @Inject constructor(
    private val dallaMainRepository: DallaMainRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        dallaMainRepository.getStarList()
    }
}