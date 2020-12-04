package com.example.marvelhq.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.marvelhq.R
import com.example.marvelhq.home.view.activity.HomeActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        backToLogin()
        gotToHome()
        textWatcherFieldName()
        textWatcherFieldEmail()
        textWatcherFieldPassword()
    }

    private fun textWatcherFieldPassword() {
        val edtPassword = findViewById<TextInputEditText>(R.id.etPasswordRegister)
        edtPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.txtPasswordRegister).error = ""
            }

        })
    }

    private fun textWatcherFieldEmail() {
        val edtUserEmail = findViewById<TextInputEditText>(R.id.etEmailRegister)
        edtUserEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.txtEmailRegister).error = ""
            }

        })
    }

    private fun textWatcherFieldName() {
        val edtUserName = findViewById<TextInputEditText>(R.id.etNameRegister)
        edtUserName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.txtNameRegister).error = ""
            }

        })
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
            if(validarEntradas()  ){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validarEntradas(): Boolean {
        var resultado = true

        val edtUserName = findViewById<TextInputEditText>(R.id.etNameRegister)
        val edtUserEmail = findViewById<TextInputEditText>(R.id.etEmailRegister)
        val edtPassword = findViewById<TextInputEditText>(R.id.etPasswordRegister)

        if (edtUserName.text?.trim()!!.isBlank()) {
            findViewById<TextInputLayout>(R.id.txtNameRegister).error = "Username Vazio"
            resultado = false
        }

        if (edtUserEmail.text?.trim()!!.isBlank()) {
            findViewById<TextInputLayout>(R.id.txtEmailRegister).error = "Username Vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            findViewById<TextInputLayout>(R.id.txtPasswordRegister).error = "Password Vazio"
            resultado = false
        }

        return resultado
    }
}