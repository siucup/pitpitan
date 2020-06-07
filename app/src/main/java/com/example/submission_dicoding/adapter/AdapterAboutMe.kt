package com.example.submission_dicoding.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.submission_dicoding.R

class AdapterAboutMe : AppCompatActivity() {

    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_JOIN = "extra_join"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val tvNama: TextView = findViewById(R.id.name)
        val tvEmail: TextView = findViewById(R.id.email)
        val tvJoin: TextView = findViewById(R.id.join)

        val nama = intent.getStringExtra(EXTRA_NAMA)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val join = intent.getStringExtra(EXTRA_JOIN)
        //titlebar
        val actionBar = supportActionBar
        actionBar!!.title = "About Me"

    }
}
