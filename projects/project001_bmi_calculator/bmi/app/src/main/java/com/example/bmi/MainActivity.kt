package com.example.bmi

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import kotlin.math.pow
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ref : Int? = 0
        val ref1Button = findViewById<Button>(R.id.ref1)
        val ref2Button = findViewById<Button>(R.id.ref2)
        val h = findViewById<EditText>(R.id.height)
        val w = findViewById<EditText>(R.id.weight)
        val calculate = findViewById<Button>(R.id.calculate)
        val resultText = findViewById<TextView>(R.id.result)
        val referenceText = findViewById<TextView>(R.id.reference)

        ref1Button.setOnClickListener {
            ref = 1
            referenceText.text = getString(R.string.ref_who97)
            ref1Button.isSelected = true
            ref2Button.isSelected = false
        }
        ref2Button.setOnClickListener {
            ref = 0
            referenceText.text = getString(R.string.ref_cdc20)
            ref1Button.isSelected = false
            ref2Button.isSelected = true
        }

        calculate.setOnClickListener {
            val bmi = bmi(w.text.toString(), h.text.toString())
            riskClassification(resultText, referenceText, ref, bmi)
        }
    }

    private fun bmi(w: String, h: String): Float{
        val weight = w.toFloatOrNull()
        val height = h.toFloatOrNull()

        return when {
            weight == 0f || height == 0f -> {
                -1.3f
            }
            weight != null && weight !in 10f..600f -> {
                -1.1f
            }
            height != null && height !in 0.2f..3f -> {
                -1.2f
            }
            weight != null && height != null -> {
                weight / height.pow(2f)
            }
            else -> {
                -1f
            }
        }
    }

    private fun riskClassification(resultText: TextView, referenceText: TextView, reference:Int?, bmi: Float) {
        val r = round(bmi*100f)/100f

        fun convert(a:String) = "${r.toString().replace(".",",")} kg/m²\n$a"

        resultText.isVisible = true
        resultText.text = if (reference == 1) {
                when (bmi) {
                    -1.3f -> {
                        getString(R.string.zero_input)
                    }
                    -1.2f -> {
                        getString(R.string.h_out_of_bounds)
                    }
                    -1.1f -> {
                        getString(R.string.w_out_of_bounds)
                    }
                    -1f -> {
                        getString(R.string.no_input)
                    }
                    in 1f..15.99f -> {
                        convert(getString(R.string.u3))
                    }
                    in 16f..16.99f -> {
                        convert(getString(R.string.u2))
                    }
                    in 17f..18.49f -> {
                        convert(getString(R.string.u1))
                    }
                    in 18.5f..24.99f -> {
                        convert(getString(R.string.nw))
                    }
                    in 25f..29.99f -> {
                        convert(getString(R.string.pre))
                    }
                    in 30f..34.99f -> {
                        convert(getString(R.string.o1))
                    }
                    in 35f..39.99f -> {
                        convert(getString(R.string.o2))
                    }
                    else -> {
                        convert(getString(R.string.o3))
                    }
                }
            } else {
                when (bmi) {
                    -1.3f -> {
                        getString(R.string.zero_input)
                    }
                    -1.2f -> {
                        getString(R.string.h_out_of_bounds)
                    }
                    -1.1f -> {
                        getString(R.string.w_out_of_bounds)
                    }
                    -1f -> {
                        getString(R.string.no_input)
                    }
                    in 1f..18.49f -> {
                        convert(getString(R.string.uw))
                    }
                    in 18.5f..24.99f -> {
                        convert(getString(R.string.nw))
                    }
                    in 25f..29.99f -> {
                        convert(getString(R.string.pre))
                    }
                    else ->  {
                        convert(getString(R.string.ob))
                    }
                }
            }

        referenceText.isVisible = bmi !in -1.3f..-1f
        referenceText.text = if (reference == 1) {
            getString(R.string.ref_who97)
        } else { getString(R.string.ref_cdc20) }

        if (riskColorAPI23(resultText, bmi) != null) {
            riskColorAPI23(resultText, bmi)
        } else {
            riskColorAPI22(resultText, bmi)
        }
    }

    private fun riskColorAPI23(a: TextView, bmi: Float): Unit? {
        val textColor: Int
        val backgroundColor: Int

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val black = Color.parseColor("#000000")
            val white = Color.parseColor("#ffffff")

            when (bmi) {
                in -1.3f..-1f -> {
                    backgroundColor = getColor(R.color.alert)
                    textColor = black
                }
                in 1f..15.99f -> {
                    backgroundColor = getColor(R.color.risk4)
                    textColor = white
                }
                in 16f..16.99f -> {
                    backgroundColor = getColor(R.color.risk3)
                    textColor = white
                }
                in 17f..18.49f -> {
                    backgroundColor = getColor(R.color.risk2)
                    textColor = white
                }
                in 18.5f..24.99f -> {
                    backgroundColor = getColor(R.color.risk0)
                    textColor = white
                }
                in 25f..29.99f -> {
                    backgroundColor = getColor(R.color.risk1)
                    textColor = black
                }
                in 30f..34.99f -> {
                    backgroundColor = getColor(R.color.risk2)
                    textColor = white
                }
                in 35f..39.99f -> {
                    backgroundColor = getColor(R.color.risk3)
                    textColor = white
                }
                else -> {
                    backgroundColor = getColor(R.color.risk4)
                    textColor = white
                }
            }
            a.setTextColor(textColor)
            a.backgroundTintList = ColorStateList.valueOf(backgroundColor)
        } else { null }
    }

    private fun riskColorAPI22(a:TextView, bmi: Float) {
        val textColor: String
        val backgroundColor: String
        val black = "#000000"
        val white = "#ffffff"

        when (bmi) {
            in -1.3f..-1f -> {
                backgroundColor = getString(R.string.alert)
                textColor = black
            }
            in 1f..15.99f -> {
                backgroundColor = getString(R.string.risk4)
                textColor = white
            }
            in 16f..16.99f -> {
                backgroundColor = getString(R.string.risk3)
                textColor = white
            }
            in 17f..18.49f -> {
                backgroundColor = getString(R.string.risk2)
                textColor = white
            }
            in 18.5f..24.99f -> {
                backgroundColor = getString(R.string.risk0)
                textColor = white
            }
            in 25f..29.99f -> {
                backgroundColor = getString(R.string.risk1)
                textColor = black
            }
            in 30f..34.99f -> {
                backgroundColor = getString(R.string.risk2)
                textColor = white
            }
            in 35f..39.99f -> {
                backgroundColor = getString(R.string.risk3)
                textColor = white
            }
            else -> {
                backgroundColor = getString(R.string.risk4)
                textColor = white
            }
        }
        a.setTextColor(Color.parseColor(textColor))
        a.backgroundTintList = ColorStateList.valueOf(Color.parseColor(backgroundColor))
    }

}