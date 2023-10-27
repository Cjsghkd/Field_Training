package com.example.main.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetAdBannerListUseCase
import com.example.domain.usecase.GetMainBannerListUseCase
import com.example.domain.usecase.GetStarListUseCase
import com.example.domain.usecase.PostRoomListUseCase
import com.example.main.view.main.extension.customUseCase
import com.example.model.model.model.ad_banner.AdBannerListModel
import com.example.model.model.model.main_banner.MainBannerListModel
import com.example.model.model.model.room.PageNoModel
import com.example.model.model.model.room.RoomListModel
import com.example.model.model.model.star.StarListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DallaMainViewModel @Inject constructor(
    private val postRoomListUseCase: PostRoomListUseCase,
    private val getMainBannerListUseCase: GetMainBannerListUseCase,
    private val getAdBannerListUseCase: GetAdBannerListUseCase,
    private val getStarListUseCase: GetStarListUseCase
): ViewModel() {
    private val _postRoomListUiState = MutableStateFlow<UiState<RoomListModel>>(UiState.Loading)
    val postRoomListUiState: StateFlow<UiState<RoomListModel>> = _postRoomListUiState

    private val _getMainBannerListUiState = MutableStateFlow<UiState<MainBannerListModel>>(UiState.Loading)
    val getMainBannerListUiState: StateFlow<UiState<MainBannerListModel>> = _getMainBannerListUiState

    private val _getAdBannerListUiState = MutableStateFlow<UiState<AdBannerListModel>>(UiState.Loading)
    val getAdBannerListUiState: StateFlow<UiState<AdBannerListModel>> = _getAdBannerListUiState

    private val _getStarListUiState = MutableStateFlow<UiState<StarListModel>>(UiState.Loading)
    val getStarListUiState: StateFlow<UiState<StarListModel>> = _getStarListUiState

    fun postRoomList(pageNo: PageNoModel) = viewModelScope.launch { postRoomListUseCase(pageNo).customUseCase(_postRoomListUiState) }

    fun getMainBannerList() = viewModelScope.launch { getMainBannerListUseCase().customUseCase(_getMainBannerListUiState) }

    fun getAdBannerList() = viewModelScope.launch { getAdBannerListUseCase().customUseCase(_getAdBannerListUiState) }

    fun getStarList() = viewModelScope.launch { getStarListUseCase().customUseCase(_getStarListUiState) }
}