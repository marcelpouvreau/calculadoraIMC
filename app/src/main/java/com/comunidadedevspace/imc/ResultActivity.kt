package com.comunidadedevspace.imc

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

        val classificacao: String = when {
            result <= 18.5f -> "MAGREZA"
            result <= 24.9f -> "NORMAL"
            result <= 29.9f -> "SOBREPESO"
            result <= 39.9f -> "OBESIDADE"
            else -> "OBESIDADE MÓRBIDA"
        }

        tvClassificacao.text = classificacao
    }
}
