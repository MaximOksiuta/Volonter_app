package com.example.volonter_app.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.volonter_app.MainActivity
import com.example.volonter_app.R
import com.example.volonter_app.databinding.FragmentEventDetailsBinding

class EventDetailsFragment: Fragment(R.layout.fragment_event_details) {
    private lateinit var binding: FragmentEventDetailsBinding
    private lateinit var dialogBuilder: AlertDialog.Builder
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentEventDetailsBinding.inflate(inflater,container,false)
        binding.imageView13.setImageResource(arguments?.get("image").toString().toInt())
        binding.textView17.text = arguments?.get("name").toString()
        binding.textView18.text = arguments?.get("time").toString()
        binding.textView19.text = arguments?.get("description").toString()
        binding.textView21.text = arguments?.get("cost").toString()
        val functionsList = arguments?.get("functions") as List<String>
        var functionsString = "Что нужно сделать:"
        for (i in functionsList){
            functionsString += "\n-$i"
        }
        binding.textView20.text = functionsString
        binding.imageView12.setOnClickListener { (requireActivity() as MainActivity).navigateTo(R.id.mainFragment) }
        binding.button4.setOnClickListener{
            (requireActivity() as MainActivity).stateInt = 3
            (requireActivity() as MainActivity).eventName = arguments?.get("name").toString()
            dialogBuilder = AlertDialog.Builder(requireActivity())
            dialogBuilder.setTitle("Вы записались на мероприятие!")
            dialogBuilder.setMessage("Вы записались на мероприятие ${arguments?.get("name").toString()}")
            dialogBuilder.setPositiveButton("Ок"){_, _ ->}
            dialogBuilder.show()
        }
        return binding.root
    }
}