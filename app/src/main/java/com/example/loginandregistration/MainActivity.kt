package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.loginandregistration.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        val username = intent.getStringExtra("username").toString()
        val password = intent.getStringExtra("password").toString()

        binding.textInputMainUsername.setText(if(username != "null") username else "")
        binding.editTextMainPassword.setText(if(password != "null") password else "")
    }

    private fun setListeners() {
        binding.textViewMainSignUp.setOnClickListener {
            Log.d(TAG, "setListeners: signUp clicked")
            val registerIntent = Intent(this, RegistrationActivity::class.java)

            registerIntent.putExtra("username", binding.textInputMainUsername.text.toString())

            startActivity(registerIntent)
        }

        binding.buttonMainLogin.setOnClickListener {
//            if(RegistrationUtil.existingUsers.contains(binding.textInputMainUsername.text.toString())) {
//                if(RegistrationUtil.validatePassword(binding.editTextMainPassword.text.toString(), binding.editTextMainPassword.text.toString())) {
//                    Log.d(TAG, "setListeners: login clicked")
//                    val homeIntent = Intent(this, HomeActivity::class.java)
//
//                    homeIntent.putExtra("username", binding.textInputMainUsername.text.toString())
//                    homeIntent.putExtra("password", binding.editTextMainPassword.text.toString())
//
//                    startActivity(homeIntent)
//                } else {
//                    Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "Invalid username", Toast.LENGTH_SHORT).show()
//            }
        }
    }
}