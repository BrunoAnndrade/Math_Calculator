package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tvResultado = findViewById<TextView>(R.id.resultado)
        val tvExpressao = findViewById<TextView>(R.id.expressao)


        // esconder a actionbar
        supportActionBar!!.hide()


        val zero = findViewById<TextView>(R.id.numero_zero)
        val um = findViewById<TextView>(R.id.numero_um)
        val dois = findViewById<TextView>(R.id.numero_dois)
        val tres = findViewById<TextView>(R.id.numero_tres)
        val quatro = findViewById<TextView>(R.id.numero_quatro)
        val cinco = findViewById<TextView>(R.id.numero_cinco)
        val seis = findViewById<TextView>(R.id.numero_seis)
        val sete = findViewById<TextView>(R.id.numero_sete)
        val oito = findViewById<TextView>(R.id.numero_oito)
        val nove = findViewById<TextView>(R.id.numero_nove)
        val ponto = findViewById<TextView>(R.id.sinalPonto)



        //Operadores
        val soma = findViewById<TextView>(R.id.adição)
        val subtraçao = findViewById<TextView>(R.id.subtração)
        val divisao = findViewById<TextView>(R.id.divisão)
        val multiplicacao = findViewById<TextView>(R.id.multiplicação)



        val igual = findViewById<TextView>(R.id.sinalIgual)
        val limparTudo = findViewById<TextView>(R.id.limparTudo)
        val backspace = findViewById<ImageView>(R.id.backspace)


        limparTudo.setOnClickListener {
            tvResultado.text = ""
            tvExpressao.text = ""
        }

        backspace.setOnClickListener {
            val string = tvExpressao.text.toString()

            if(string.isNotBlank()){
                tvExpressao.text = string.substring(0,string.length-1)
            }
            tvResultado.text = ""
        }


        igual.setOnClickListener{

            try {
                val expressao = ExpressionBuilder(tvExpressao.text.toString()).build()

                //número double
                val resultado = expressao.evaluate()
                //numero inteiro long
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble()){
                    tvResultado.text = longResult.toString()
                } else{
                    tvResultado.text = resultado.toString()
                }

            } catch (_:Exception){

            }

        }



        fun acrescentarUmaExpressao(string: String, limpar: Boolean) {

            if (tvResultado.text.isNotEmpty()) {
                tvExpressao.text = ""
            }
            if (limpar) {
                tvResultado.text = ""
                tvExpressao.append(string)
            } else {
                tvExpressao.append(tvResultado.text)
                tvExpressao.append(string)
            }
        }


        zero.setOnClickListener { acrescentarUmaExpressao("0", true) }
        um.setOnClickListener { acrescentarUmaExpressao("1", true) }
        dois.setOnClickListener { acrescentarUmaExpressao("2", true) }
        tres.setOnClickListener { acrescentarUmaExpressao("3", true) }
        quatro.setOnClickListener { acrescentarUmaExpressao("4", true) }
        cinco.setOnClickListener { acrescentarUmaExpressao("5", true) }
        seis.setOnClickListener { acrescentarUmaExpressao("6", true) }
        sete.setOnClickListener { acrescentarUmaExpressao("7", true) }
        oito.setOnClickListener { acrescentarUmaExpressao("8", true) }
        nove.setOnClickListener { acrescentarUmaExpressao("9", true) }
        ponto.setOnClickListener { acrescentarUmaExpressao(".", true) }


        soma.setOnClickListener { acrescentarUmaExpressao("+", false) }
        subtraçao.setOnClickListener { acrescentarUmaExpressao("-", false) }
        divisao.setOnClickListener { acrescentarUmaExpressao("/", false) }
        multiplicacao.setOnClickListener { acrescentarUmaExpressao("*", false) }


    }


}