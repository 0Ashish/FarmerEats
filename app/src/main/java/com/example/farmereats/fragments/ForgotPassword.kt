package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentForgotPasswordBinding

class ForgotPassword : Fragment() {
    private lateinit var binding:FragmentForgotPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentForgotPasswordBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}