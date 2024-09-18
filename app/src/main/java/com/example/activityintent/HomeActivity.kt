package com.example.activityintent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tvUsername: TextView = findViewById(R.id.tvUsername)
        val tvEmail: TextView = findViewById(R.id.tvEmail)
        val tvPhone: TextView = findViewById(R.id.tvPhone)
        val tvGender: TextView = findViewById(R.id.tvGender)

        // Ambil data dari Intent
        val username = intent.getStringExtra("USER_USERNAME")
        val email = intent.getStringExtra("USER_EMAIL")
        val phone = intent.getStringExtra("USER_PHONE")
        val gender = intent.getStringExtra("USER_GENDER")

        // Tampilkan data di TextView
        tvUsername.text = "Nama: $username"
        tvEmail.text = "Email: $email"
        tvPhone.text = "Nomor HP: $phone"
        tvGender.text = "Jenis Kelamin: $gender"
    }
}
