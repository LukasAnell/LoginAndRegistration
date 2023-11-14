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

    var name: String = ""
    var username: String = ""
    var password: String = ""
    var email: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        val username = intent.getStringExtra("username") ?: ""

        binding.textInputRegistrationUsername.setText(username)
    }

    private fun setListeners() {
        binding.buttonRegistrationRegister.setOnClickListener {
            Log.d(TAG, "setListeners: register clicked")
            val loginIntent = Intent(this, MainActivity::class.java)

            name = binding.textInputRegistrationName.text.toString()
            username = binding.textInputRegistrationUsername.text.toString()
            password = binding.editTextRegistrationPassword.text.toString()
            email = binding.textInputRegistrationEmail.text.toString()

            loginIntent.putExtra("username", username)
            loginIntent.putExtra("password", password)

            startActivity(loginIntent)
        }
    }
}