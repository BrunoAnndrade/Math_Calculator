package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // esconder a actionbar
        supportActionBar!!.hide()


        numero_zero.setOnClickListener { acrescentarUmaExpressao("0", true) }
        numero_um.setOnClickListener { acrescentarUmaExpressao("1", true) }
        numero_dois.setOnClickListener { acrescentarUmaExpressao("2", true) }
        numero_tres.setOnClickListener { acrescentarUmaExpressao("3", true) }
        numero_quatro.setOnClickListener { acrescentarUmaExpressao("4", true) }
        numero_cinco.setOnClickListener { acrescentarUmaExpressao("5", true) }
        numero_seis.setOnClickListener { acrescentarUmaExpressao("6", true) }
        numero_sete.setOnClickListener { acrescentarUmaExpressao("7", true) }
        numero_oito.setOnClickListener { acrescentarUmaExpressao("8", true) }
        numero_nove.setOnClickListener { acrescentarUmaExpressao("9", true) }


    }

    fun acrescentarUmaExpressao(string: String, limpar: Boolean) {

        if (resultado.text.isNotEmpty()) {
            expressao.text = ""
        }
        if (limpar) {
            resultado.text = ""
            expressao.append(string)
        } else {
            expressao.append(string)
            resultado.append(string)
        }
    }


}