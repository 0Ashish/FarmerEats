package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentSignUpBinding
import com.example.farmereats.databinding.FragmentSignUpFarmInfoBinding

class SignUpFarmInfo : Fragment() {
    private lateinit var binding: FragmentSignUpFarmInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpFarmInfoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backtoSignUp1.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFarmInfo_to_signUp)
        }
        binding.continueToVerification.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFarmInfo_to_signUpVerification)
        }
    }
}