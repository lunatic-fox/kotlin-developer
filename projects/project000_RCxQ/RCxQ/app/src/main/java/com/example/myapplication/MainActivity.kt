package com.example.myapplication


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val feminino = findViewById<Button>(R.id.feminino)
        val masculino = findViewById<Button>(R.id.masculino)
        val cc = findViewById<TextView>(R.id.cc)
        val cq = findViewById<TextView>(R.id.cq)
        val calcular = findViewById<TextView>(R.id.calcular)
        val bSelect = getDrawable(R.drawable.bselect)
        val bIdle = getDrawable(R.drawable.button)

        var sex = ""

        feminino.setOnClickListener {
            sex = "f"
            feminino.background = bSelect
            masculino.background = bIdle
        }
        masculino.setOnClickListener {
            sex = "m"
            feminino.background = bIdle
            masculino.background = bSelect
        }

        calcular.setOnClickListener {
            val circ = cc.text.toString()
            val cirq = cq.text.toString()
            calc(circ, cirq, sex)
        }
    }

    private fun calc(a: String, b: String, sex: String):String {
        val result = findViewById<TextView>(R.id.result)

        try {
            val r = a.toDouble() / b.toDouble()

            val msg = when (sex) {
                "m" -> {
                    if (r >= 1) {
                        result.setTextColor(Color.parseColor("#F44336"))
                        "${round(r * 100) / 100}\n" + getString(R.string.risk)
                    } else {
                        result.setTextColor(Color.parseColor("#4CAF50"))
                        "${round(r * 100) / 100}\n" + getString(R.string.no_risk)
                    }
                }
                "f" -> {
                    if (r >= 0.85) {
                        result.setTextColor(Color.parseColor("#F44336"))
                        "${round(r * 100) / 100}\n" + getString(R.string.risk)
                    } else {
                        result.setTextColor(Color.parseColor("#4CAF50"))
                        "${round(r * 100) / 100}\n" + getString(R.string.no_risk)
                    }
                }else -> getString(R.string.selection_error)
            }
            result.text = msg
            return result.text as String

        } catch (e: Exception) {
            result.text = getString(R.string.number_excp)
            return result.text as String
        }
    }
}





