package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentHappyBinding

class Happy : Fragment() {
    private lateinit var binding: FragmentHappyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHappyBinding.inflate(inflater, container, false)

        binding.callLogin.setOnClickListener{
            findNavController().navigate(R.id.action_happy_to_login)
        }
        return binding.root
    }
}