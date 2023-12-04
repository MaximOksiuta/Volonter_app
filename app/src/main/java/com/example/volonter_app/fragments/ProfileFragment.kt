package com.example.volonter_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.volonter_app.MainActivity
import com.example.volonter_app.R
import com.example.volonter_app.databinding.FragmentProfileBinding

class ProfileFragment: Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        updateUI()
        binding.cardView4.setOnClickListener {
            if (binding.imageView7.visibility == View.VISIBLE){
                binding.imageView8.visibility = View.VISIBLE
                binding.textView9.visibility = View.VISIBLE
                binding.imageView7.visibility = View.INVISIBLE
            } else{
                binding.imageView8.visibility = View.INVISIBLE
                binding.textView9.visibility = View.INVISIBLE
                binding.imageView7.visibility = View.VISIBLE
            }
        }
        binding.cardView3.setOnLongClickListener {
            when((requireActivity() as MainActivity).stateInt){
                1 -> {
                    (requireActivity() as MainActivity).stateInt = 2
                    updateUI()
                    return@setOnLongClickListener true
                }
                2 -> {
                    (requireActivity() as MainActivity).stateInt = 1
                    updateUI()
                    return@setOnLongClickListener true
                }
                3 -> {
                    (requireActivity() as MainActivity).stateInt = 2
                    updateUI()
                    return@setOnLongClickListener true
                }
                else -> {return@setOnLongClickListener  false}
            }
        }
        binding.button3.setOnClickListener { (requireActivity() as MainActivity).navigateTo(R.id.signInFragment) }
        return binding.root
    }
    fun updateUI(){
        when ((requireActivity() as MainActivity).stateInt){
            1 -> {binding.cardView5.visibility = View.VISIBLE
            binding.textView7.text = "Последнее событие 25 дней назад"}
            2 -> {binding.cardView5.visibility = View.GONE
                binding.textView7.text = "Последнее событие 5 дней назад"}
            3 -> {binding.cardView5.visibility = View.GONE
                binding.textView7.text = "Следующее событие - ${(requireActivity() as MainActivity).eventName}"
            }
        }
    }
}