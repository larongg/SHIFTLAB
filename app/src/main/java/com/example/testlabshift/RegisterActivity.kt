package com.example.testlabshift

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var firstName: EditText
    private lateinit var secondName: EditText
    private lateinit var date: EditText
    private lateinit var password: EditText
    private lateinit var passwordCheck: EditText
    private lateinit var regButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firstName = findViewById(R.id.firstName)
        secondName = findViewById(R.id.secondName)
        date = findViewById(R.id.date)
        password = findViewById(R.id.password)
        passwordCheck = findViewById(R.id.passwordCheck)
        regButton = findViewById(R.id.regButton)
    }

    fun register(@Suppress("UNUSED_PARAMETER") view: View) {
        if (!firstName.text.isNullOrEmpty()) {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java).apply {
                putExtra("firstName", firstName.text.toString())
            }
            startActivity(intent)
        }
    }
}