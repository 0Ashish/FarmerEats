package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentLoginBinding
import com.example.farmereats.databinding.FragmentResetPaswordBinding

class ResetPassword : Fragment() {
    private lateinit var binding: FragmentResetPaswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetPaswordBinding.inflate(layoutInflater)
        return binding.root
    }
}