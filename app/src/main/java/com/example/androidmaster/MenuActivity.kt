package com.example.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.bmicalculator.BmiCalculatorActivity
import com.example.androidmaster.firstapp.FirstAppActivity
import com.example.androidmaster.todoapp.TodoActivity
import com.example.androidmaster.webview.WebViewActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnWebviewApp = findViewById<Button>(R.id.btnWebViewApp)
        val btnGreetApp = findViewById<Button>(R.id.btnGreetApp)
        val btnBmiApp = findViewById<Button>(R.id.btnBMIApp)
        val btnTODOApp = findViewById<Button>(R.id.btnTODOApp)

        btnWebviewApp.setOnClickListener { navigateToWebViewApp() }
        btnGreetApp.setOnClickListener { navigateToGreetApp() }
        btnBmiApp.setOnClickListener { navigateToBMIApp() }
        btnTODOApp.setOnClickListener { navigateToTODOApp() }
    }

    private fun navigateToWebViewApp() {
        val intent = Intent(this, WebViewActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToGreetApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBMIApp() {
        val intent = Intent(this, BmiCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}