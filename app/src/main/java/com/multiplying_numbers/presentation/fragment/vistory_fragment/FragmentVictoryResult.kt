package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.databinding.FragmentVictoryResultBinding


class FragmentVictoryResult : Fragment() {
    private val args by navArgs<FragmentVictoryResultArgs>()
    private lateinit var binding: FragmentVictoryResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVictoryResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.listResultAnswer?.toList()?.let {
            val list = it.map { it.questions to (it.countWrongAnswer) }
            Log.d("TAG1", "onViewCreated: list = $list")

        }
    }


}