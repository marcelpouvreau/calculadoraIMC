package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC_159"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0F)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val (classificacao, cor) = when {
            result <= 18.5f -> "MAGREZA" to Color.RED
            result <= 24.9f -> "NORMAL" to Color.GREEN
            result <= 29.9f -> "SOBREPESO" to Color.parseColor("#800080") // Roxo
            result <= 39.9f -> "OBESIDADE" to Color.RED
            else -> "OBESIDADE MÓRBIDA" to Color.RED
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(cor)
    }
}
