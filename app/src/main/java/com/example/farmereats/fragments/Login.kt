package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindng.tvCreateAccount.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_signUp)
        }
        bindng.tvForgotPassword.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_forgotPassword)
        }
    }


}