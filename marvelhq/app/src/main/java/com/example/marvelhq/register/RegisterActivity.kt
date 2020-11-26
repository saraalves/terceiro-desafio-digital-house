package com.example.marvelhq.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelhq.R
import com.example.marvelhq.home.HomeActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        backToLogin()
        gotToHome()

    }

    private fun backToLogin() {
        val btnBack = findViewById<MaterialToolbar>(R.id.topAppBarRegister)
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun gotToHome() {
        val btnSalvar = findViewById<MaterialButton>(R.id.btnSalvar)
        btnSalvar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}