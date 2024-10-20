package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentSignUpBinding


class SignUp : Fragment() {
    private lateinit var binding :FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listener on the login TextView
        binding.loginFromSignUpPage.setOnClickListener {
            // Navigate to LoginFragment
            findNavController().navigate(R.id.action_signUp_to_login)

        }
        binding.continueTo2ndPage.setOnClickListener{
            findNavController().navigate(R.id.action_signUp_to_signUpFarmInfo)
        }
    }
}