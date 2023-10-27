package com.example.main.view.main

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.main.R
import com.example.main.databinding.ActivityMainBinding
import com.example.main.view.adapter.AdvertisementBannerAdapter
import com.example.main.view.adapter.FollowingBjAdapter
import com.example.main.view.adapter.LiveBjAdapter
import com.example.main.view.adapter.MainBannerAdapter
import com.example.main.view.adapter.NewBjAdapter
import com.example.main.view.adapter.TopBjAdapter
import com.example.main.view.main.extension.customLifecycleScope
import com.example.model.model.model.ad_banner.AdBannerModel
import com.example.model.model.model.example.NewRecyclerViewRequestModel
import com.example.model.model.model.example.TopRecyclerViewRequestModel
import com.example.model.model.model.room.PageNoModel
import com.example.model.model.model.star.ProfImgModel
import com.example.model.model.model.star.StarModel
import com.example.main.view.util.setCurrentItemWithDuration
import com.example.main.view.util.setItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: DallaMainViewModel by viewModels()

    var mainBannerJob: Job = Job()
    var advertisementBannerJob: Job = Job()
    var advertisementBannerList = emptyList<AdBannerModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(mainViewModel) {
            getMainBannerList()
            getAdBannerList()
            getStarList()
            postRoomList(pageNo = PageNoModel(1))
        }

        initGetData()
        initScrollView()
        initRecyclerView()
        initTipBar()
        scrollJobCreate()

        binding.bjText.setOnClickListener {
            binding.bjText.setTextColor(Color.parseColor("#202020"))
            binding.fanText.setTextColor(Color.parseColor("#acacac"))
            binding.teamText.setTextColor(Color.parseColor("#acacac"))
        }

        binding.fanText.setOnClickListener {
            binding.bjText.setTextColor(Color.parseColor("#acacac"))
            binding.fanText.setTextColor(Color.parseColor("#202020"))
            binding.teamText.setTextColor(Color.parseColor("#acacac"))
        }

        binding.teamText.setOnClickListener {
            binding.bjText.setTextColor(Color.parseColor("#acacac"))
            binding.fanText.setTextColor(Color.parseColor("#acacac"))
            binding.teamText.setTextColor(Color.parseColor("#202020"))
        }

        binding.bottomNavigateBar.itemIconTintList = null
        binding.bottomNavigateBar.itemActiveIndicatorColor = null

//        binding.button.setOnClickListener {
//            ProfileBottomSheetDialogFragment().show(supportFragmentManager, "BottomSheet")
//        }
    }

    private fun initGetData() {
        customLifecycleScope(this) {
            mainViewModel.getMainBannerListUiState.collectLatest {
                when(it) {
                    is UiState.Success -> {
                        val mainBannerAdapter = MainBannerAdapter(it.data.BannerList)
                        binding.mainBanner.adapter = mainBannerAdapter
                        binding.mainBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                    }
                    is UiState.Error -> {}
                    is UiState.Loading -> {}
                }
            }
        }

        customLifecycleScope(this) {
            mainViewModel.getStarListUiState.collectLatest {
                when(it) {
                    is UiState.Success -> {
                        val followingBjList = it.data.StarList

                        if (followingBjList.size > 10) {
                            val newFollowingBjList = followingBjList.slice(0..9).toMutableList()
                            newFollowingBjList.add(
                                newFollowingBjList.lastIndex,
                                StarModel(
                                    background = null,
                                    whiteBackground = null,
                                    nickNm = null,
                                    profImg = ProfImgModel(com.example.ui.R.drawable.etc_bj_background.toString()),  // 수정 필요
                                    count = "+${followingBjList.size - newFollowingBjList.size}"
                                )
                            )
                            val followingBjAdapter = FollowingBjAdapter(newFollowingBjList)
                            binding.followingRecyclerView.adapter = followingBjAdapter
                        } else {
                            val followingBjAdapter = FollowingBjAdapter(followingBjList)
                            binding.followingRecyclerView.adapter = followingBjAdapter
                        }
                    }
                    is UiState.Error -> {}
                    is UiState.Loading -> {}
                }
            }
        }

        customLifecycleScope(this) {
            mainViewModel.getAdBannerListUiState.collectLatest {
                when(it) {
                    is UiState.Success -> {
                        advertisementBannerList = it.data.BannerList
                        val advertisementBannerAdapter = AdvertisementBannerAdapter(advertisementBannerList)
                        binding.advertisementBanner.adapter = advertisementBannerAdapter
                        binding.advertisementBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                        binding.bannerText.text = "1 / ${advertisementBannerList.size}"
                    }
                    is UiState.Error -> {}
                    is UiState.Loading -> {}
                }
            }
        }

        customLifecycleScope(this) {
            mainViewModel.postRoomListUiState.collectLatest {
                when(it) {
                    is UiState.Success -> {
                        val liveBjAdapter = LiveBjAdapter(it.data.RoomList)
                        binding.liveBjRecyclerView.adapter = liveBjAdapter
                    }
                    is UiState.Error -> {}
                    is UiState.Loading -> {}
                }
            }
        }
    }

    private fun initScrollView() {
        binding.scrollView.run {
            header = binding.tabLayout
            appbar = binding.toolBar
        }

        binding.scrollView.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            when (scrollY) {
                in 0..369 -> {
                    binding.iconLayout.setImageResource(R.drawable.ico_set)
                    binding.toolBar.alpha = 0f
                    binding.dallaLogo.alpha = 0f
                    binding.iconLayout.alpha = 1f
                }

                in 370..750 -> {
                    binding.iconLayout.setImageResource(R.drawable.ico_set_black)
                    binding.toolBar.alpha = 1f * (scrollY / 750f)
                    binding.dallaLogo.alpha = 1f * (scrollY / 750f)
                    binding.iconLayout.alpha = 1f * (scrollY / 750f)
                }

                else -> {
                    binding.toolBar.alpha = 1f
                    binding.dallaLogo.alpha = 1f
                    binding.iconLayout.alpha = 1f
                }
            }
        }
    }

    private fun initRecyclerView() {
        val topBjList = listOf(
            TopRecyclerViewRequestModel(
                background = R.drawable.main_one_background,
                rank = R.drawable.number_w_1,
                icon = R.drawable.btn_mini_live,
                name = "달대리찡"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_two_background,
                rank = R.drawable.number_w_2,
                icon = R.drawable.btn_mini_live,
                name = "사랑이M̶"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_three_background,
                rank = R.drawable.number_w_3,
                icon = R.drawable.btn_mini_listen,
                name = "달라쑝"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_four_background,
                rank = R.drawable.number_w_4,
                icon = R.drawable.btn_mini_live,
                name = "달대리찡"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_five_background,
                rank = R.drawable.number_w_5,
                icon = R.drawable.btn_mini_live,
                name = "사랑이M̶"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_six_background,
                rank = R.drawable.number_w_6,
                icon = R.drawable.btn_mini_listen,
                name = "달라쑝"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_one_background,
                rank = R.drawable.number_w_7,
                icon = R.drawable.btn_mini_live,
                name = "달대리찡"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_two_background,
                rank = R.drawable.number_w_8,
                icon = R.drawable.btn_mini_live,
                name = "사랑이M̶"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_three_background,
                rank = R.drawable.number_w_9,
                icon = R.drawable.btn_mini_listen,
                name = "달라쑝"
            ),
            TopRecyclerViewRequestModel(
                background = R.drawable.main_four_background,
                rank = R.drawable.number_w_10,
                icon = R.drawable.btn_mini_live,
                name = "달대리찡"
            ),
        )

        val newBjList = listOf(
            NewRecyclerViewRequestModel(
                background = R.drawable.main_four_background,
                name = "한개두개세개"
            ),
            NewRecyclerViewRequestModel(
                background = R.drawable.main_five_background,
                name = "개팔자가상팔자라더니"
            ),
            NewRecyclerViewRequestModel(
                background = R.drawable.main_six_background,
                name = "아이유 닮은 저에"
            ),
            NewRecyclerViewRequestModel(
                background = R.drawable.main_four_background,
                name = "한개두개세개"
            ),
            NewRecyclerViewRequestModel(
                background = R.drawable.main_five_background,
                name = "개팔자가상팔자라더니"
            ),
            NewRecyclerViewRequestModel(
                background = R.drawable.main_six_background,
                name = "아이유 닮은 저에"
            )
        )

        val topBjAdapter = TopBjAdapter(topBjList)
        binding.topBjRecyclerView.setItemDecoration(4)
        binding.topBjRecyclerView.adapter = topBjAdapter
        binding.topBjRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val newBjAdapter = NewBjAdapter(newBjList)
        binding.newBjRecyclerView.setItemDecoration(4)
        binding.newBjRecyclerView.adapter = newBjAdapter
        binding.newBjRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.liveBjRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.followingRecyclerView.setItemDecoration(5)
        binding.followingRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun initTipBar() {
        val builder = SpannableStringBuilder(binding.tipText.text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 5, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(StyleSpan(Typeface.BOLD), 12, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tipText.text = builder
    }

    private fun scrollJobCreate() {
        binding.mainBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            var bannerPosition = 0

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bannerPosition = position
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                when (state) {
                    ViewPager2.SCROLL_STATE_IDLE -> {
                        if (!mainBannerJob.isActive) {
                            mainBannerJob = bannerScroll(
                                job = mainBannerJob,
                                delaySeconds = 6000,
                                itemDuration = 1500
                            )
                        }
                    }

                    ViewPager2.SCROLL_STATE_DRAGGING -> {
                        mainBannerJob.cancel()
                    }

                    ViewPager2.SCROLL_STATE_SETTLING -> {}
                }
            }
        })

        binding.advertisementBanner.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            var bannerPosition = 0

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bannerPosition = position
                binding.bannerText.text = "${(bannerPosition % advertisementBannerList.size) + 1} / ${advertisementBannerList.size}"
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                when (state) {
                    ViewPager2.SCROLL_STATE_IDLE -> {
                        if (!advertisementBannerJob.isActive) {
                            advertisementBannerJob = bannerScroll(
                                job = advertisementBannerJob,
                                delaySeconds = 3000,
                                itemDuration = 1000
                            )
                        }
                    }

                    ViewPager2.SCROLL_STATE_DRAGGING -> {
                        advertisementBannerJob.cancel()
                    }

                    ViewPager2.SCROLL_STATE_SETTLING -> {}
                }
            }
        })
    }

    fun bannerScroll(
        job: Job,
        delaySeconds: Long,
        itemDuration: Long
    ): Job {
        var bannerJob = job

        bannerJob = lifecycleScope.launch {
            while (true) {
                delay(delaySeconds)
                if (bannerJob == mainBannerJob) binding.mainBanner.setCurrentItemWithDuration(itemDuration)
                else binding.advertisementBanner.setCurrentItemWithDuration(itemDuration)
            }
        }
        bannerJob.start()
        return bannerJob
    }

}
