package com.crincongtz.layouts

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

const val TAG = "CursoKotlin"

class MainActivity : AppCompatActivity() {

    //    var linearLayout1: LinearLayout? = null
    //    var linearLayout2: LinearLayout? = null

    var tvNumber: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        setContentView(R.layout.linear_layout)
        //        setContentView(R.layout.relative_layout)
        //        setContentView(R.layout.table_layout)
        //        setContentView(R.layout.frame_layout)

        tvNumber = findViewById(R.id.tvNumber) // Referencia a la vista XML

        val buttonToast = findViewById<Button>(R.id.buttonToast)
        buttonToast.setOnClickListener {
            Toast.makeText(this, "este es un Toast", Toast.LENGTH_LONG).show()
        }

        val buttonCounter = findViewById<Button>(R.id.buttonCounter)
        buttonCounter.setOnClickListener {
            val number = tvNumber!!.text.toString().toInt() // TEXT, convierto a string, convierto a INTEGER
            tvNumber!!.text = number.inc().toString()
        }

        val buttonAlert = findViewById<Button>(R.id.buttonAlert)  // INMUTABLE
        buttonAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alerta!!")
                .setMessage("Este es una Alerta")
                .setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                    //                    Log.d(TAG, "accion POSITIVA")
                }
                .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                    //                    Log.d(TAG, "accion NEGATIVA")
                    finish()
                }
                .show()
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart()")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i(TAG, "onRestoreInstanceState() - Se recreó la app de nuevo")
        val numberSaved = savedInstanceState.getString("MyNumber")
        tvNumber!!.text = numberSaved
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i(TAG, "onSaveInstanceState() - Se Detectó giro de app")
        val numberToSave = tvNumber!!.text.toString()
        outState.putString("MyNumber", numberToSave)

        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        Log.d(TAG, "onResume()")
        Toast.makeText(this, "este es un Toast", Toast.LENGTH_LONG).show()
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.w(TAG, "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy()")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.i(TAG, "onRestart()")
        super.onRestart()
    }
}