package com.example.testlabshift

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstName = intent.getStringExtra("firstName")
        dialog = Dialog(this@MainActivity)
        dialog.setContentView(R.layout.dialog_view)
        val textView = dialog.findViewById<TextView>(R.id.helloText)
        textView.text = getString(R.string.dialog, firstName)
    }

    fun hello(@Suppress("UNUSED_PARAMETER") view: View){
        dialog.show()
    }
}