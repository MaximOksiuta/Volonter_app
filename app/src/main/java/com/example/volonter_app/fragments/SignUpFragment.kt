package com.example.volonter_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.volonter_app.MainActivity
import com.example.volonter_app.R
import com.example.volonter_app.databinding.FragmentSignUpBinding

class SignUpFragment: Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener { (requireActivity() as MainActivity).navigateTo(R.id.mainFragment) }
        binding.button2.setOnClickListener { (requireActivity() as MainActivity).navigateTo(R.id.signInFragment) }
        return binding.root
    }
}