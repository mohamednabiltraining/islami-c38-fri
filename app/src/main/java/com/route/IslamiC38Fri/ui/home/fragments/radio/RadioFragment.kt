package com.route.IslamiC38Fri.ui.home.fragments.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.IslamiC38Fri.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    lateinit var binding: FragmentRadioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding
            .inflate(inflater, container, false)
        return binding.root
    }
}