package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.loginandregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var textViewSignUp: TextView
    private lateinit var buttonLogin: Button

    companion object {
        const val TAG = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        wireWidgets()
        setListeners()
    }

    private fun setListeners() {
        textViewSignUp.setOnClickListener {
            Log.d(TAG, "setListeners: signUp clicked")
            val registerIntent = Intent(this, RegistrationActivity::class.java)
            startActivity(registerIntent)
        }
    }

    private fun wireWidgets() {
        textViewSignUp = findViewById(R.id.textView_main_signUp)
        buttonLogin = findViewById(R.id.button_main_login)
    }
}