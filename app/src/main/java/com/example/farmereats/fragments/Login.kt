package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentLoginBinding

class Login : Fragment() {
    private lateinit var bindng :FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindng = FragmentLoginBinding.inflate(inflater, container, false) // Correctly inflate the binding
        return bindng.root // Return the root view of the binding

    }


}