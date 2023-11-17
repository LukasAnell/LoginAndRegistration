package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        val username = intent.getStringExtra("username").toString()
        val password = intent.getStringExtra("password").toString()

        binding.textInputLoginUsername.setText(if(username != "null") username else "")
        binding.editTextLoginPassword.setText(if(password != "null") password else "")
    }

    private fun setListeners() {
        binding.textViewLoginSignUp.setOnClickListener {
            Log.d(TAG, "setListeners: signUp clicked")
            val registerIntent = Intent(this, RegistrationActivity::class.java)

            registerIntent.putExtra("username", binding.textInputLoginUsername.text.toString())

            startActivity(registerIntent)
        }

        binding.buttonLoginLogin.setOnClickListener {
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