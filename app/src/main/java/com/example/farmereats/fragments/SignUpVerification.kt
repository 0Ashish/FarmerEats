package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentSignUpVerificationBinding

class SignUpVerification : Fragment() {
    private lateinit var binding:FragmentSignUpVerificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpVerificationBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.continueToHoursPage.setOnClickListener{
            findNavController().navigate(R.id.action_signUpVerification_to_signUpHours)
        }
        binding.backToFarmInfo.setOnClickListener{
            findNavController().navigate(R.id.action_signUpVerification_to_signUpFarmInfo)
        }
    }
}