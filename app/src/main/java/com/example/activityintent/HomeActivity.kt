package com.example.registration

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activityintent.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPhone = findViewById<TextView>(R.id.tvPhone)
        val tvGender = findViewById<TextView>(R.id.tvGender)

        // Mengambil data dari LoginActivity
        val username = intent.getStringExtra("USERNAME")
        val email = intent.getStringExtra("EMAIL")
        val phone = intent.getStringExtra("PHONE")
        val gender = intent.getStringExtra("GENDER")

        // Menampilkan data di profil
        tvUsername.text = "Nama: $username"
        tvEmail.text = "Email: $email"
        tvPhone.text = "Nomor HP: $phone"
        tvGender.text = "Jenis Kelamin: $gender"
    }
}
