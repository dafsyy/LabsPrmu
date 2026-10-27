package com.example.marketapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this,
                    "Заполните email и пароль",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else {
                val intent = android.content.Intent(
                    this,
                    FeedActivity::class.java
                )
                startActivity(intent)
                finish()
            }
        }

        tvRegister.setOnClickListener {
            val intent = android.content.Intent(
                this,
                RegisterActivity::class.java
            )
            startActivity(intent)
        }
    }
}