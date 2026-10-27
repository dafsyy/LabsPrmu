package com.example.marketapp

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FeedActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var listingContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        etSearch = findViewById(R.id.etSearch)
        listingContainer = findViewById(R.id.listingContainer)

        val btnProfile = findViewById<TextView>(R.id.btnProfile)
        val btnAddListing = findViewById<Button>(R.id.btnAddListing)

        val listing1 = findViewById<LinearLayout>(R.id.listing1)
        val listing2 = findViewById<LinearLayout>(R.id.listing2)

        listing1.setOnClickListener {
            Toast.makeText(
                this,
                "Детали объявления добавим следующим этапом",
                Toast.LENGTH_SHORT
            ).show()
        }

        listing2.setOnClickListener {
            Toast.makeText(
                this,
                "Детали объявления добавим следующим этапом",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnProfile.setOnClickListener {
            Toast.makeText(
                this,
                "Экран профиля сделаем позже",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnAddListing.setOnClickListener {
            Toast.makeText(
                this,
                "Экран подачи объявления сделаем позже",
                Toast.LENGTH_SHORT
            ).show()
        }

        etSearch.addTextChangedListener(
            object : android.text.TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) = Unit

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    filterListings(s.toString())
                }

                override fun afterTextChanged(
                    s: android.text.Editable?
                ) = Unit
            }
        )
    }

    private fun filterListings(query: String) {
        val search = query.trim().lowercase()

        for (i in 0 until listingContainer.childCount) {
            val item = listingContainer.getChildAt(i)
            val text = findListingText(item)

            item.visibility = if (
                search.isEmpty() || text.contains(search)
            ) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun findListingText(view: View): String {
        val result = StringBuilder()

        if (view is TextView) {
            result.append(view.text).append(" ")
        }

        if (view is android.view.ViewGroup) {
            for (i in 0 until view.childCount) {
                result.append(findListingText(view.getChildAt(i)))
                result.append(" ")
            }
        }

        return result.toString().lowercase()
    }
}