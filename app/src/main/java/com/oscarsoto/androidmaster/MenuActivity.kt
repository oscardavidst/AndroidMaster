package com.oscarsoto.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.oscarsoto.androidmaster.firstapp.FirstAppActivity
import com.oscarsoto.androidmaster.heroapp.HeroListActivity
import com.oscarsoto.androidmaster.imccalculator.ImcCalculatorActivity
import com.oscarsoto.androidmaster.todoapp.ToDoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDoApp = findViewById<Button>(R.id.btnToDoApp)
        val btnHeroApp = findViewById<Button>(R.id.btnHeroApp)

        btnHelloApp.setOnClickListener { navigateToHelloApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnToDoApp.setOnClickListener { navigateToToDoApp() }
        btnHeroApp.setOnClickListener { navigateToHeroApp() }
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToToDoApp() {
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHeroApp() {
        val intent = Intent(this, HeroListActivity::class.java)
        startActivity(intent)
    }
}