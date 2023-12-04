package com.example.volonter_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.volonter_app.MainActivity
import com.example.volonter_app.R
import com.example.volonter_app.databinding.FragmentSignInBinding

class SignInFragment: Fragment(R.layout.fragment_sign_in) {
    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentSignInBinding.inflate(inflater,container,false)
        binding.button.setOnClickListener { (requireActivity() as MainActivity).navigateTo(R.id.mainFragment) }
        binding.button2.setOnClickListener { (requireActivity() as MainActivity).navigateTo(R.id.signUpFragment) }
        return binding.root
    }
}