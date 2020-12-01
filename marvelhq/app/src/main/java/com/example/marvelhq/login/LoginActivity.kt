package com.example.marvelhq.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.marvelhq.R
import com.example.marvelhq.home.view.activity.HomeActivity
import com.example.marvelhq.register.RegisterActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        goToRegister()
        goToHome()
        textWatcherFieldEmail()
        textWatcherFieldPassword()
    }

    private fun goToRegister() {
        val btnCreateAccount = findViewById<MaterialButton>(R.id.btnCreateAccount)
        btnCreateAccount.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToHome() {
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if(validarEntradas()){
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validarEntradas(): Boolean {
        var resultado = true

        val edtUserEmail = findViewById<TextInputEditText>(R.id.etEmailLogin)
        val edtPassword = findViewById<TextInputEditText>(R.id.etPasswordLogin)

        if (edtUserEmail.text?.trim()!!.isBlank()) {
            findViewById<TextInputLayout>(R.id.txtEmailLogin).error = "Username Vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = "Username Vazio"
            resultado = false
        }

        return resultado
    }

    private fun textWatcherFieldPassword() {
        val edtPassword = findViewById<TextInputEditText>(R.id.etPasswordLogin)
        edtPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = ""
            }

        })
    }

    private fun textWatcherFieldEmail() {
        val edtUserEmail = findViewById<TextInputEditText>(R.id.etEmailLogin)
        edtUserEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.txtEmailLogin).error = ""
            }

        })
    }
}