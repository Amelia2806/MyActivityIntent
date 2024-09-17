package com.example.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activityintent.R
import com.example.activityintent.RegisterActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // Mengambil data dari halaman Registrasi
        val registeredUsername = intent.getStringExtra("USERNAME")
        val registeredEmail = intent.getStringExtra("EMAIL")
        val registeredPhone = intent.getStringExtra("PHONE")
        val registeredGender = intent.getStringExtra("GENDER")

        // Ketika tombol Login diklik
        btnLogin.setOnClickListener {
            val inputUsername = etUsername.text.toString()
            val inputPassword = etPassword.text.toString()

            // Validasi sederhana untuk login
            if (inputUsername == registeredUsername && inputPassword.isNotEmpty()) {
                // Login berhasil, kirim data ke halaman Profile
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("USERNAME", registeredUsername)
                    putExtra("EMAIL", registeredEmail)
                    putExtra("PHONE", registeredPhone)
                    putExtra("GENDER", registeredGender)
                }
                startActivity(intent)
            } else {
                // Jika login gagal, tampilkan pesan error (contoh sederhana)
                etPassword.error = "Invalid credentials"
            }
        }

        // Pindah ke halaman registrasi jika belum punya akun
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
