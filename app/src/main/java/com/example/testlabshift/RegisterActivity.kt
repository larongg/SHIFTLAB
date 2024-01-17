package com.example.testlabshift

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

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
        regButton.isEnabled = false

        val bools = mutableMapOf(
            "firstName" to false,
            "secondName" to false,
            "date" to false,
            "password" to false,
            "passwordCheck" to false,
        )

        firstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isNameValid(firstName.text.toString())) {
                    bools["firstName"] = true
                    if (bools.all { it.value }) {
                        regButton.isEnabled = true
                    }
                } else {
                    bools["firstName"] = false
                    regButton.isEnabled = false
                }
            }
        })

        secondName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isNameValid(secondName.text.toString())) {
                    bools["secondName"] = true
                    if (bools.all { it.value }) {
                        regButton.isEnabled = true
                    }
                } else {
                    bools["secondName"] = false
                    regButton.isEnabled = false
                }
            }
        })

        date.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isDateValid(date.text.toString())) {
                    bools["date"] = true
                    if (bools.all { it.value }) {
                        regButton.isEnabled = true
                    }
                } else {
                    bools["date"] = false
                    regButton.isEnabled = false
                }
            }
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isPasswordValid(password.text.toString()) && (password.text.toString() == passwordCheck.text.toString())) {
                    bools["password"] = true
                    bools["passwordCheck"] = true
                    if (bools.all { it.value }) {
                        regButton.isEnabled = true
                    }
                } else {
                    bools["password"] = false
                    bools["passwordCheck"] = false
                    regButton.isEnabled = false
                }
            }
        })

        passwordCheck.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isPasswordValid(password.text.toString()) && (password.text.toString() == passwordCheck.text.toString())) {
                    bools["password"] = true
                    bools["passwordCheck"] = true
                    if (bools.all { it.value }) {
                        regButton.isEnabled = true
                    }
                } else {
                    bools["password"] = false
                    bools["passwordCheck"] = false
                    regButton.isEnabled = false
                }
            }
        })
    }

    fun register(@Suppress("UNUSED_PARAMETER") view: View) {
        val intent = Intent(this@RegisterActivity, MainActivity::class.java).apply {
            putExtra("firstName", firstName.text.toString())
        }
        startActivity(intent)
    }

    private fun isDateValid(date: String): Boolean {
        val dateFormat = SimpleDateFormat("dd.MM.yyyy")
        dateFormat.isLenient = false

        return try {
            dateFormat.parse(date)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        if (password.length < 8) return false
        if (password.filter { it.isDigit() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }
                .firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }
                .firstOrNull() == null) return false
        if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true
    }

    private fun isNameValid(name: String): Boolean {
        if (name.length < 2) return false
        if (name.any { it.isDigit() }) return false
        if (name != name.toLowerCase().capitalize()) return false

        return true
    }
}