package com.oscarsoto.androidmaster.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.oscarsoto.androidmaster.R
import com.oscarsoto.androidmaster.imccalculator.ImcCalculatorActivity.Companion.EXTRA_IMC
import java.text.DecimalFormat

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var btnRecalculate: AppCompatButton
    private lateinit var tvStateImc: TextView
    private lateinit var tvImcResult: TextView
    private lateinit var tvObservationImc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)

        val imc:Double = intent.extras?.getDouble(EXTRA_IMC) ?: -1.0
        initComponents()
        initListeners()
        initUI(imc)
    }

    private fun initComponents() {
        btnRecalculate = findViewById(R.id.btnRecalculate)
        tvStateImc = findViewById(R.id.tvStateResult)
        tvImcResult = findViewById(R.id.tvImcResult)
        tvObservationImc = findViewById(R.id.tvObservationResult)
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { navigateToImcCalculator() }
    }

    private fun initUI(imc: Double) {
        when (imc) {
            in 0f..18.49f -> {
                tvStateImc.text = getString(R.string.tittle_peso_bajo)
                tvObservationImc.text = getString(R.string.description_peso_bajo)
            }

            in 18.5f..24.99f -> {
                tvStateImc.text = getString(R.string.tittle_peso_normal)
                tvStateImc.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvObservationImc.text = getString(R.string.description_peso_normal)
            }

            in 25f..29.99f -> {
                tvStateImc.text = getString(R.string.tittle_peso_superior)
                tvObservationImc.text = getString(R.string.description_peso_superior)
            }

            in 30f..150f -> {
                tvStateImc.text = getString(R.string.tittle_peso_obesidad)
                tvObservationImc.text = getString(R.string.description_peso_obesidad)
            }

            else -> {
                tvStateImc.text = getString(R.string.error)
                tvObservationImc.text = getString(R.string.error)
            }
        }
        val decimalFomat = DecimalFormat("#.##")
        tvImcResult.setText(decimalFomat.format(imc).toString())
    }

    private fun navigateToImcCalculator() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }
}