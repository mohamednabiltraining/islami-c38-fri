package com.route.IslamiC38Fri.ui.home.fragments.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.IslamiC38Fri.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {

    lateinit var binding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding
            .inflate(inflater, container, false)
        return binding.root
    }
}