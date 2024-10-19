package com.example.farmereats.fragments

import ApiRepository
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentOtpBinding

class Otp : Fragment() {
    private lateinit var binding : FragmentOtpBinding
    private lateinit var apiRepository: ApiRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOtpBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.loginfromverifyOtp.setOnClickListener{
            findNavController().navigate(R.id.action_otp_to_login)
        }
        clickCall()
    }

    fun clickCall() {
        binding.submitotp.setOnClickListener{
            val otp = binding.etOtp1.text.toString()+binding.etOtp2.text.toString()+binding.etOtp3.text.toString()+binding.etOtp4.text.toString()
            apiRepository.verifyOtp(
                otp
            ){
                it.fold({
                    // Handle success
                    Log.d("response",it.toString())
                    findNavController().navigate(R.id.resetPassword)
                },{
                    // Handle failure
                })
            }
        }
    }
}