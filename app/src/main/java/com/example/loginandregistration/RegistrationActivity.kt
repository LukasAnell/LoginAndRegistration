package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity: AppCompatActivity() {
    companion object {
        const val TAG = "RegistrationActivity"

        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    private lateinit var binding: ActivityRegistrationBinding

    var name: String = ""
    var username: String = ""
    var password: String = ""
    var email: String = ""
    var confirmPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME) ?: ""
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD) ?: ""

        binding.textInputRegistrationUsername.setText(if(username != "null") username else "")
        binding.editTextRegistrationPassword.setText(if(password != "null") password else "")
    }

    private fun setListeners() {
        binding.buttonRegistrationRegister.setOnClickListener {
            Log.d(TAG, "setListeners: register clicked")

            name = binding.textInputRegistrationName.text.toString()
            username = binding.textInputRegistrationUsername.text.toString()
            password = binding.editTextRegistrationPassword.text.toString()
            email = binding.textInputRegistrationEmail.text.toString()
            confirmPassword = binding.editTextRegistrationConfirmPassword.text.toString()

            if(RegistrationUtil.validatePassword(password, confirmPassword) &&
                RegistrationUtil.validateUsername(username) &&
                RegistrationUtil.validateName(name) &&
                RegistrationUtil.validateEmail(email)) {

                RegistrationUtil.existingUsers = RegistrationUtil.existingUsers.plus(username)
                Log.d(TAG, "existingUsers: ${RegistrationUtil.existingUsers}")

                val resultIntent = Intent().apply {
                    putExtra(EXTRA_USERNAME, binding.textInputRegistrationUsername.text.toString())
                    putExtra(EXTRA_PASSWORD, binding.editTextRegistrationPassword.text.toString())
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Please make sure all fields are filled out correctly", Toast.LENGTH_SHORT).show()
            }

        }
    }
}