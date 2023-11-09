package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity: AppCompatActivity() {
    companion object {
        const val TAG = "RegistrationActivity"
    }

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var buttonRegister: Button

    private var name: String=""
    private var username: String = ""
    private var password: String = ""
    private var email: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        wireWidgets()
        setListeners()
    }

    private fun setListeners() {
        buttonRegister.setOnClickListener {
            Log.d(TAG, "setListeners: register clicked")
            val loginIntent = Intent(this, MainActivity::class.java)
            startActivity(loginIntent)
        }
    }

    private fun wireWidgets() {
        buttonRegister = findViewById(R.id.button_registration_register)
    }
}