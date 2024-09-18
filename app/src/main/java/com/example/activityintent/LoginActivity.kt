package com.example.activityintent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername: EditText = findViewById(R.id.etUsername)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvRegister: TextView = findViewById(R.id.tvRegister)

        // Ambil data dari RegisterActivity
        val username = intent.getStringExtra("REGISTERED_USERNAME")
        val email = intent.getStringExtra("REGISTERED_EMAIL")
        val phoneNumber = intent.getStringExtra("REGISTERED_PHONE")
        val gender = intent.getStringExtra("REGISTERED_GENDER")

        etUsername.setText(username) // Set username jika diperlukan

        btnLogin.setOnClickListener {
            val password = etPassword.text.toString()
            // Kirim data ke HomeActivity setelah login berhasil
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("USER_USERNAME", username)
                putExtra("USER_EMAIL", email)
                putExtra("USER_PHONE", phoneNumber)
                putExtra("USER_GENDER", gender)
            }
            startActivity(intent)
        }

        tvRegister.setOnClickListener {
            // Navigasi ke halaman Registrasi
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
