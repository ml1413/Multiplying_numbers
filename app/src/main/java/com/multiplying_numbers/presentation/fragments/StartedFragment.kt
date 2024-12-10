package com.multiplying_numbers.presentation.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.multiplying_numbers.databinding.FragmentStartedBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "StartedFragment"

class StartedFragment : Fragment() {
    private lateinit var binding: FragmentStartedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvFirst.text = "2"
            tvSymbol.text = "+"
            tvSecond.text = "2"
            setAnimationOnTextView()
        }
    }

    /** otherFun__________________________________________________________________________________*/
    private fun setAnimationOnTextView() {
        binding.tvSymbol.apply {
            val scale = ObjectAnimator
                .ofFloat(this, View.ALPHA, 0f, 1f)
                .apply {
                    duration = 1000
                    repeatMode = ObjectAnimator.REVERSE
                }
            lifecycleScope.launch {
                val listSymbol = listOf("+", "-", "×", "÷")
                repeatOnLifecycle(Lifecycle.State.RESUMED) {
                    repeat(100) {
                        text = listSymbol.random()
                        scale.start()
                        delay(2000)
                    }
                }
            }
        }
    }
}

