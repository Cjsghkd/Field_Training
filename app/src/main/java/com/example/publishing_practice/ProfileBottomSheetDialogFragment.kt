package com.example.publishing_practice

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.publishing_practice.databinding.FragmentProfileBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProfileBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentProfileBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBottomSheetDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(STYLE_NORMAL, R.style.TransparentBottomSheetDialogTheme)
        return super.onCreateDialog(savedInstanceState)
    }
}