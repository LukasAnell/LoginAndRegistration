package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.loginandregistration.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityMainBinding

    private val EXTRA_USERNAME = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        val username = intent.getStringExtra(RegistrationActivity.username).toString() ?: ""
        val password = intent.getStringExtra("password").toString() ?: ""

        binding.textInputMainUsername.setText(username)
        binding.textInputMainPassword.setText(password)
    }

    private fun setListeners() {
        binding.textViewMainSignUp.setOnClickListener {
            Log.d(TAG, "setListeners: signUp clicked")
            val registerIntent = Intent(this, RegistrationActivity::class.java)

            registerIntent.putExtra(EXTRA_USERNAME, binding.textInputMainUsername.text.toString())

            startActivity(registerIntent)
        }

        binding.buttonMainLogin.setOnClickListener {

        }
    }
}