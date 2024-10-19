package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentSignUpVerification2Binding


class SignUpVerification2 : Fragment() {
    private lateinit var binding :FragmentSignUpVerification2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpVerification2Binding.inflate(layoutInflater,container,false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backtoHours.setOnClickListener{
            findNavController().navigate(R.id.action_signUpVerification2_to_signUpHours)
        }
        binding.submitToConfirm.setOnClickListener{
            findNavController().navigate(R.id.action_signUpVerification2_to_signUpConfirmation)
        }
    }

}