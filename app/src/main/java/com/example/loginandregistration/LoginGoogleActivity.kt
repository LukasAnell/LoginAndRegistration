package com.example.loginandregistration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandregistration.databinding.ActivityuLoginGoogleBinding

class LoginGoogleActivity: AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityuLoginGoogleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityuLoginGoogleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {}
}