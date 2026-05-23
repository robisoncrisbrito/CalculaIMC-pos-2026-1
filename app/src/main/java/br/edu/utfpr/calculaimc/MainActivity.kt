package br.edu.utfpr.calculaimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btCalcular: Button
    private lateinit var btLimpar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)

        btCalcular.setOnClickListener {
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener {
            btLimparOnClick()
        }

        btCalcular.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.calcular_clique_longo),
                Toast.LENGTH_LONG
            ).show()

            true
        }


    } //fim do onCreate()

    private fun btLimparOnClick() {

        etPeso.setText("")
        etAltura.setText("")

        tvResultado.text = getString(R.string.zeros)

        etPeso.requestFocus()


    } //fim btLimparOnClick

    private fun btCalcularOnClick() {

        //entrada
        val pesoStr = etPeso.text.toString()
        val alturaStr = etAltura.text.toString()

        val peso = pesoStr.toDoubleOrNull()
        val altura = alturaStr.toDoubleOrNull()

        if (peso == null) {
            etPeso.error = getString(R.string.erro_peso)
            return
        }

        if (altura == null) {
            etAltura.error = getString(R.string.erro_altura)
            return
        }

        if ( altura == 0.0 ) {
            etAltura.error = getString(R.string.erro_zeros_altura)
            return
        }

        //processamento
        val imc = peso / altura.pow(2)

        //saída
        tvResultado.text = "%.2f".format(imc)


    } //fim btCalcularOnClick

} //fim da MainActivity