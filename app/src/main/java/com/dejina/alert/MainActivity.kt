package com.example.alert

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.dejina.alert.R

class  MainActivity : AppCompatActivity() {
    private lateinit var btnClick : Button
    private lateinit var etFirst : EditText
    private lateinit var etSecond : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick = findViewById(R.id.btnClick)
        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)

        btnClick.setOnClickListener{
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Alert")

            builder.setMessage("Are you sure")
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton("Yes"){ _: DialogInterface?, _ ->
                Toast.makeText(applicationContext, "Pressed yes", Toast.LENGTH_SHORT).show()
                var sum = etFirst.text.toString().toInt() + etSecond.text.toString().toInt()
                Toast.makeText(applicationContext, "The sum is $sum", Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel"){ _: DialogInterface?, _ ->
                Toast.makeText(applicationContext, "Pressed cancel", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){ _: DialogInterface?, _ ->
                Toast.makeText(applicationContext, "Pressed no", Toast.LENGTH_SHORT).show()
            }

            val alertDialog : AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }
    }
}