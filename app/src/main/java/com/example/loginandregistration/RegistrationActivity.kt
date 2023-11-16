package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
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

        binding.textInputRegistrationUsername.setText(if(password != "null") username else "")
    }

    private fun setListeners() {
        binding.buttonRegistrationRegister.setOnClickListener {
            Log.d(TAG, "setListeners: register clicked")
            val loginIntent = Intent(this, MainActivity::class.java)

            name = binding.textInputRegistrationName.text.toString()
            username = binding.textInputRegistrationUsername.text.toString()
            password = binding.editTextRegistrationPassword.text.toString()
            email = binding.textInputRegistrationEmail.text.toString()

            RegistrationUtil.existingUsers = RegistrationUtil.existingUsers.plus(username)
            Log.d(TAG, "existingUsers: ${RegistrationUtil.existingUsers}")

            loginIntent.putExtra("username", username)
            loginIntent.putExtra("password", password)
            startActivity(loginIntent)
        }

        binding.textInputRegistrationUsername.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.buttonRegistrationRegister.isEnabled = RegistrationUtil.validateUsername(binding.textInputRegistrationUsername.text.toString())
                Toast.makeText(this@RegistrationActivity, "Username must be at least 3 characters long and not already taken", Toast.LENGTH_SHORT).show()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // do nothing
            }
        })

        binding.editTextRegistrationPassword.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.buttonRegistrationRegister.isEnabled = RegistrationUtil.validatePassword(binding.editTextRegistrationPassword.text.toString(), binding.editTextRegistrationConfirmPassword.text.toString())
                Toast.makeText(this@RegistrationActivity, "Password must be at least 8 characters long, contain at least one digit and one capital letter, and match the confirm password", Toast.LENGTH_SHORT).show()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // do nothing
            }
        })

        binding.textInputRegistrationName.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.buttonRegistrationRegister.isEnabled = RegistrationUtil.validateName(binding.textInputRegistrationName.text.toString())
                Toast.makeText(this@RegistrationActivity, "Name must not be empty", Toast.LENGTH_SHORT).show()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // do nothing
            }
        })

        binding.textInputRegistrationEmail.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.buttonRegistrationRegister.isEnabled = RegistrationUtil.validateEmail(binding.textInputRegistrationEmail.text.toString())
                Toast.makeText(this@RegistrationActivity, "Email must not be empty, must not be already taken, and must be in the proper email format", Toast.LENGTH_SHORT).show()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // do nothing
            }
        })
    }
}