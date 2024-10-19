package com.example.farmereats.fragments

import ApiRepository
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentForgotPasswordBinding

class ForgotPassword : BaseApiFragment() {
    private lateinit var binding:FragmentForgotPasswordBinding
    private lateinit var apiRepository: ApiRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentForgotPasswordBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickCall()
    }

    fun clickCall() {
        binding.sendOtp.setOnClickListener{
            val mobile = binding.etphone.text.toString()
            apiRepository.forgotPassword(
               mobile
            ){
                it.fold({
                    // Handle success
                    Log.d("response",it.toString())
                    findNavController().navigate(R.id.otp)
                },{
                    // Handle failure
                    Log.d("response",it.toString())
                })
            }
        }
    }

}