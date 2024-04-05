package com.oscarsoto.androidmaster.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.oscarsoto.androidmaster.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val etName = findViewById<AppCompatEditText>(R.id.etNombre)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)

        btnStart.setOnClickListener() {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                val intentResult = Intent(this, ResultActivity::class.java)
                intentResult.putExtra("EXTRA_NAME", name)
                startActivity(intentResult)
            }
        }
    }
}