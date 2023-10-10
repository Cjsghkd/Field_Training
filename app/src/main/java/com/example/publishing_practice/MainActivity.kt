package com.example.publishing_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.publishing_practice.adapter.LiveBjAdapter
import com.example.publishing_practice.adapter.NewBjAdapter
import com.example.publishing_practice.adapter.TopBjAdapter
import com.example.publishing_practice.databinding.ActivityMainBinding
import com.example.publishing_practice.model.LiveRecyclerViewRequestModel
import com.example.publishing_practice.model.NewRecyclerViewRequestModel
import com.example.publishing_practice.model.TopRecyclerViewRequestModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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
        )
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

    val liveBjList = listOf(
        LiveRecyclerViewRequestModel(
            background = R.drawable.main_one_background,
            gender = R.drawable.ico_female,
            heart = R.drawable.heart,
            title = "달빛 가족 화이팅 하시구요!!",
            name = "씅디제이",
            peopleCount = "22",
            heartCount = "234"
        ),
        LiveRecyclerViewRequestModel(
            background = R.drawable.main_two_background,
            gender = R.drawable.ico_male,
            heart = R.drawable.heart,
            title = "달빛 가족 화이팅 하시구요!!",
            name = "씅디제이",
            peopleCount = "27",
            heartCount = "233"
        ),
        LiveRecyclerViewRequestModel(
            background = R.drawable.main_three_background,
            gender = R.drawable.ico_female,
            heart = R.drawable.ico_booster_2,
            title = "달빛 가족 화이팅 하시구요!!",
            name = "씅디제이",
            peopleCount = "22",
            heartCount = "234"
        ),
        LiveRecyclerViewRequestModel(
            background = R.drawable.main_four_background,
            gender = R.drawable.ico_female,
            heart = R.drawable.heart,
            title = "달빛 가족 화이팅 하시구요!!",
            name = "씅디제이",
            peopleCount = "23",
            heartCount = "239"
        ),
        LiveRecyclerViewRequestModel(
            background = R.drawable.main_five_background,
            gender = R.drawable.ico_female,
            heart = R.drawable.ico_booster_2,
            title = "달빛 가족 화이팅 하시구요!!",
            name = "씅디제이",
            peopleCount = "22",
            heartCount = "234"
        ),
        LiveRecyclerViewRequestModel(
            background = R.drawable.main_six_background,
            gender = R.drawable.ico_male,
            heart = R.drawable.heart,
            title = "달빛 가족 화이팅 하시구요!!",
            name = "씅디제이",
            peopleCount = "25",
            heartCount = "231"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

//        binding.button.setOnClickListener {
//            ProfileBottomSheetDialogFragment().show(supportFragmentManager, "BottomSheet")
//        }
    }
    private fun initRecyclerView() {
        val topBjAdapter = TopBjAdapter(topBjList)
        binding.topBjRecyclerView.adapter = topBjAdapter
        binding.topBjRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val newBjAdapter = NewBjAdapter(newBjList)
        binding.newBjRecyclerView.adapter = newBjAdapter
        binding.newBjRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val liveBjAdapter = LiveBjAdapter(liveBjList)
        binding.liveBjRecyclerView.adapter = liveBjAdapter
        binding.liveBjRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
