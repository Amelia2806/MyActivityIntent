package com.example.activityintent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister: Button = findViewById(R.id.btnRegister)
        val etUsername: EditText = findViewById(R.id.etUsername)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPhoneNumber: EditText = findViewById(R.id.etPhone)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val tvLogin: TextView = findViewById(R.id.tvLogin)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            val intent = Intent(this, LoginActivity::class.java).apply {
                putExtra("REGISTERED_USERNAME", username)
                putExtra("REGISTERED_EMAIL", email)
                putExtra("REGISTERED_PHONE", phoneNumber)
                putExtra("REGISTERED_GENDER", gender)
            }
            startActivity(intent)
        }

        // Set up click listener for the "Log In" TextView
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
