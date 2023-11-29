package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"

        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent to do whatever we need with the returned info
            binding.textInputLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        val username = intent.getStringExtra(RegistrationActivity.EXTRA_USERNAME).toString()
        val password = intent.getStringExtra(RegistrationActivity.EXTRA_PASSWORD).toString()

        binding.textInputLoginUsername.setText(if(username != "null") username else "")
        binding.editTextLoginPassword.setText(if(password != "null") password else "")
    }

    private fun setListeners() {
        binding.textViewLoginSignUp.setOnClickListener {
            Log.d(TAG, "setListeners: signUp clicked")
            val registerIntent = Intent(this, RegistrationActivity::class.java)

            registerIntent.putExtra(EXTRA_USERNAME, binding.textInputLoginUsername.text.toString())
            registerIntent.putExtra(EXTRA_PASSWORD, binding.editTextLoginPassword.text.toString())

//            startActivity(registerIntent)

            startRegistrationForResult.launch(registerIntent)
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