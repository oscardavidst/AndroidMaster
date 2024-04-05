package com.oscarsoto.androidmaster.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.oscarsoto.androidmaster.R
import com.oscarsoto.androidmaster.exercises.printNotificationSummary
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_IMC = "IMC_RESULT"
    }

    private var genderSelected: Int = Gender.Male.ordinal
    private var currentWeight: Int = 50
    private var currentHeight: Int = 150
    private var currentAge: Int = 25

    private lateinit var cvMale: CardView
    private lateinit var cvFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnCalculate: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        cvMale = findViewById(R.id.cvMale)
        cvFemale = findViewById(R.id.cvFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvAge = findViewById(R.id.tvAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        cvMale.setOnClickListener { selectedCardMale() }
        cvFemale.setOnClickListener { selectedCardFemale() }
        rsHeight.addOnChangeListener { _, value, _ -> changeHeight(value) }
        btnSubtractWeight.setOnClickListener { subtractWeight() }
        btnPlusWeight.setOnClickListener { plusWeight() }
        btnSubtractAge.setOnClickListener { subtractAge() }
        btnPlusAge.setOnClickListener { plusAge() }
        btnCalculate.setOnClickListener { navigateToResultImc(calculateImc()) }
    }

    private fun initUI() {
        setBackgroudColorGender()
        setHeight()
        setWeight()
        setAge()
    }

    private fun setHeight() {
        tvHeight.text = "$currentHeight cm"
        rsHeight.setValues(currentHeight.toFloat())
    }

    private fun calculateImc(): Double {
        return currentWeight.toDouble() / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
    }

    private fun navigateToResultImc(imc: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(EXTRA_IMC, imc)
        startActivity(intent)
    }

    private fun subtractWeight() {
        currentWeight--
        setWeight()
    }

    private fun plusWeight() {
        currentWeight++
        setWeight()
    }

    private fun setWeight() {
        tvWeight.setText(currentWeight.toString())
    }

    private fun subtractAge() {
        currentAge--
        setAge()
    }

    private fun plusAge() {
        currentAge++
        setAge()
    }

    private fun setAge() {
        tvAge.setText(currentAge.toString())
    }

    private fun changeHeight(value: Float) {
        currentHeight = value.toInt()
        setHeight()
    }

    private fun setBackgroudColorGender() {
        val colorReferenceMale: Int
        val colorReferenceFemale: Int
        when (genderSelected) {
            Gender.Male.ordinal -> {
                colorReferenceMale = R.color.background_component_selected
                colorReferenceFemale = R.color.background_component
            }

            Gender.Female.ordinal -> {
                colorReferenceMale = R.color.background_component
                colorReferenceFemale = R.color.background_component_selected
            }

            else -> {
                colorReferenceMale = R.color.background_component
                colorReferenceFemale = R.color.background_component
            }
        }
        cvMale.setCardBackgroundColor(ContextCompat.getColor(this, colorReferenceMale))
        cvFemale.setCardBackgroundColor(ContextCompat.getColor(this, colorReferenceFemale))
    }

    private fun selectedCardMale() {
        genderSelected = 1
        setBackgroudColorGender()
    }

    private fun selectedCardFemale() {
        genderSelected = 0
        setBackgroudColorGender()
    }
}