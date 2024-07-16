package com.example.androidmaster.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.R
import com.example.androidmaster.bmicalculator.BmiCalculatorActivity.Companion.BMI_KEY

class ResultBMIActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvBMI: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_bmiactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result: Double = intent.extras?.getDouble(BMI_KEY) ?: -1.0

        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initUI(result: Double) {

        tvBMI.text = result.toString()

        when(result) {
            in 0.00..18.50 -> { // under
                tvResult.text = getString(R.string.title_under_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
                tvDescription.text = getString(R.string.description_under_weight)
            }
            in 18.51..24.99 -> { // normal
                tvResult.text = getString(R.string.title_normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescription.text = getString(R.string.description_normal_weight)
            }
            in 25.00..29.99 -> { // over
                tvResult.text = getString(R.string.title_over_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
                tvDescription.text = getString(R.string.description_over_weight)
            }
            in 30.00..99.99 -> { // obesity
                tvResult.text = getString(R.string.title_obesity_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity_weight))
                tvDescription.text = getString(R.string.description_obesity_weight)
            }
            else -> { // error
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity_weight))
                tvBMI.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvBMI = findViewById(R.id.tvBMI)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}