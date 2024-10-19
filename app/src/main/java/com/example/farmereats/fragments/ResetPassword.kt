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
import com.example.farmereats.databinding.FragmentLoginBinding
import com.example.farmereats.databinding.FragmentResetPaswordBinding

class ResetPassword : Fragment() {
    private lateinit var binding: FragmentResetPaswordBinding
    private lateinit var apiRepository: ApiRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetPaswordBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginfromresetpass.setOnClickListener{
            findNavController().navigate(R.id.action_resetPassword2_to_login)
        }
        clickCall()
    }
    fun clickCall() {
        binding.submitPassword.setOnClickListener{
            val password = binding.newPass.text.toString()
            val cpassword = binding.confirmPassword.text.toString()
            if(password.equals(cpassword)){
                apiRepository.resetPassword(
                    token = "token",
                    password,
                    cpassword
                ){
                    it.fold({
                        // Handle success
                        Log.d("response",it.toString())
                        findNavController().navigate(R.id.login)
                    },{
                        // Handle failure
                    })
                }
            }
        }
    }
}