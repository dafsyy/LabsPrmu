package com.example.marketapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvPage: TextView
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnNext: Button
    private lateinit var btnSkip: Button

    private var currentPage = 0

    private val titles = arrayOf(
        "Находите то, что нужно",
        "Продавайте легко",
        "Начните прямо сейчас"
    )

    private val descriptions = arrayOf(
        "Покупайте и продавайте вещи просто и удобно.",
        "Размещайте объявления и находите покупателей.",
        "Всё необходимое для покупок и продаж в одном месте."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPage = findViewById(R.id.tvPage)
        tvTitle = findViewById(R.id.tvTitle)
        tvDescription = findViewById(R.id.tvDescription)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)

        showPage()

        btnNext.setOnClickListener {
            if (currentPage < 2) {
                currentPage++
                showPage()
            } else {
                openLogin()
            }
        }

        btnSkip.setOnClickListener {
            openLogin()
        }
    }

    private fun showPage() {
        tvPage.text = "${currentPage + 1} / 3"
        tvTitle.text = titles[currentPage]
        tvDescription.text = descriptions[currentPage]

        if (currentPage == 2) {
            btnNext.text = "Начать"
            btnSkip.visibility = android.view.View.GONE
        } else {
            btnNext.text = "Далее"
            btnSkip.visibility = android.view.View.VISIBLE
            btnSkip.text = "Пропустить"
        }
    }

    private fun openLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}