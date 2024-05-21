package com.example.evaluacion

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etSueldo: EditText = findViewById(R.id.etSueldo)
        val etSueldoBasico: EditText = findViewById(R.id.etSueldoBasico)
        val etMesesTrabajados: EditText = findViewById(R.id.etMesesTrabajados)
        val rgSector: RadioGroup = findViewById(R.id.rgSector)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val tvResultado: TextView = findViewById(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val sueldo = etSueldo.text.toString().toDoubleOrNull() ?: 0.0
            val sueldoBasico = etSueldoBasico.text.toString().toDoubleOrNull() ?: 0.0
            val mesesTrabajados = etMesesTrabajados.text.toString().toIntOrNull() ?: 0

            val sectorPrivado = rgSector.checkedRadioButtonId == R.id.rbPrivado
            val aportePersonal = if (sectorPrivado) 0.0945 else 0.1145
            val aportePatronal = if (sectorPrivado) 0.1115 else 0.0915

            val aporteEmpleado = sueldo * aportePersonal
            val aporteEmpleador = sueldo * aportePatronal
            val decimoTercero = (mesesTrabajados * sueldo) / 12
            val decimoCuarto = (mesesTrabajados * sueldoBasico) / 12

            val resultado = """
                Sueldo: $sueldo
                Aporte Empleado: $aporteEmpleado
                Aporte Empleador: $aporteEmpleador
                Décimo Tercero: $decimoTercero
                Décimo Cuarto: $decimoCuarto
            """.trimIndent()

            tvResultado.text = resultado
        }
    }
}
