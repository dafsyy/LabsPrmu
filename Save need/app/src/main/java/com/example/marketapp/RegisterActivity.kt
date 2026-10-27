package com.example.marketapp

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etPasswordRepeat =
            findViewById<EditText>(R.id.etPasswordRepeat)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvBackToLogin = findViewById<TextView>(R.id.tvBackToLogin)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val passwordRepeat = etPasswordRepeat.text.toString()

            when {
                username.isEmpty() ||
                        email.isEmpty() ||
                        password.isEmpty() ||
                        passwordRepeat.isEmpty() -> {
                    showMessage("Заполните все поля")
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    etEmail.error = "Введите корректный email"
                    etEmail.requestFocus()
                }

                password.length < 6 -> {
                    etPassword.error =
                        "Пароль должен содержать минимум 6 символов"
                    etPassword.requestFocus()
                }

                password != passwordRepeat -> {
                    etPasswordRepeat.error = "Пароли не совпадают"
                    etPasswordRepeat.requestFocus()
                }

                else -> {
                    showMessage(
                        "Проверка пройдена. Сохранение добавим позже."
                    )
                }
            }
        }

        tvBackToLogin.setOnClickListener {
            finish()
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}