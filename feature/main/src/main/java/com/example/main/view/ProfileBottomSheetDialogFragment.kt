package com.example.main.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.main.R
import com.example.main.databinding.FragmentProfileBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

internal class ProfileBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentProfileBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_bottom_sheet_dialog, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(STYLE_NORMAL, R.style.TransparentBottomSheetDialogTheme)
        return super.onCreateDialog(savedInstanceState)
    }
}