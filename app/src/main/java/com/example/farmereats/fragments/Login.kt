package com.example.farmereats.fragments

import ApiRepository
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmereats.ApiService
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentLoginBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Login : BaseApiFragment() {
    private lateinit var binding :FragmentLoginBinding
    private lateinit var apiRepository: ApiRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false) // Correctly inflate the binding
        return binding.root // Return the root view of the binding

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCreateAccount.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_signUp)
        }
        binding.tvForgotPassword.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_forgotPassword)
        }
        clickCall()
    }


    fun clickCall() {
        binding.btnLogin.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val device_token = ""
            val type = ""
            val social_id = ""
            val role = ""
            apiRepository.userLogin(
                email,password,role,
                device_token,type,social_id
            ){
                it.fold({
                    // Handle success
                    Log.d("response",it.toString())
                },{
                    // Handle failure
                    Log.d("response",it.toString())
                })
            }
        }
    }

}