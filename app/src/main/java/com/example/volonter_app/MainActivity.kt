package com.example.volonter_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.volonter_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    var stateInt = 2 // 1 - 25 дней прошло, через 5 дней сгорят все баллы. 2 - прошло 5 дней все оки. 3 - следующее событие ---
    var eventName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.findNavController()
        setContentView(binding.root)
    }
    fun navigateTo(id: Int){
        navController.navigate(id)
    }
    fun navigateTo(id: Int, bundle: Bundle){
        navController.navigate(id, bundle)
    }

}