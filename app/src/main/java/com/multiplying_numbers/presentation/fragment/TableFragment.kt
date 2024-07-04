package com.multiplying_numbers.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.multiplying_numbers.databinding.FragmentTableBinding


class TableFragment : Fragment() {
    private lateinit var binding: FragmentTableBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTableBinding.inflate(inflater, container, false)
        return binding.root
    }

}