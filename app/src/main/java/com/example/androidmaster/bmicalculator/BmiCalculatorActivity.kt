package com.example.androidmaster.bmicalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class BmiCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentHeight: Int = 100
    private var currentWeight: Int = 80
    private var currentAge: Int = 20

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rgHeight: RangeSlider
    private lateinit var buttonSubtractWeight: FloatingActionButton
    private lateinit var buttonPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var buttonSubtractAge: FloatingActionButton
    private lateinit var buttonPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    companion object {
        const val BMI_KEY = "BMI_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rgHeight = findViewById(R.id.rgHeight)
        buttonSubtractWeight = findViewById(R.id.buttonSubtractWeight)
        buttonPlusWeight = findViewById(R.id.buttonPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        buttonSubtractAge = findViewById(R.id.buttonSubtractAge)
        buttonPlusAge = findViewById(R.id.buttonPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender(true)
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender(false)
            setGenderColor()
        }
        rgHeight.addOnChangeListener { _, value, _ ->
            // way 1
            // tvHeight.text = "${value.toInt().toString()} cm"

            // way 2
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            // tvHeight.text = "$currentHeight cm"

            val height = resources.getString(R.string.heightValue, currentHeight.toString())
            tvHeight.text = height
        }
        buttonSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        buttonPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        buttonSubtractAge.setOnClickListener {
           currentAge -= 1
           setAge()
        }
        buttonPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateBMI()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultBMIActivity::class.java)
        intent.putExtra(BMI_KEY, result)
        startActivity(intent)
    }

    private fun calculateBMI(): Double {
        val df = DecimalFormat("#.##")
        val bmi = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(bmi).toDouble()
    }

    private fun setHeight() {
        // tvHeight.text = "$currentHeight cm"
        val height = getString(R.string.heightValue, currentHeight.toString())
        tvHeight.text = height
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender(male: Boolean) {
        // way 3
        if (male && !isMaleSelected) {
            isMaleSelected = true
            isFemaleSelected = false
        }
        else if (!male && !isFemaleSelected) {
            isFemaleSelected = true
            isMaleSelected = false
        }

        // Way 2: fixed bug
        //if (maleClick) {
        //    if (!isMaleSelected) {
        //        isMaleSelected = true
        //        isFemaleSelected = false
        //    }
        //}
        //else {
        //    if (!isFemaleSelected) {
        //        isFemaleSelected = true
        //        isMaleSelected = false
        //    }
        //}

        // Way 1: It is has bug
        //isMaleSelected = !isMaleSelected
        //isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setHeight()
        setWeight()
        setAge()
    }
}