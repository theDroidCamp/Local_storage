package com.olgatech.droidcamptask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.signup_activity.*

class SignUpActivity: AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var emailAddress: EditText
    private lateinit var password: EditText
    private lateinit var school: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        name = editTextName
        emailAddress = editTextEmail
        password = editTextPassword
        school = editTextSchool

        signup_button.setOnClickListener {
            saveThisData()
        }
    }

    private fun saveThisData() {

        when {
            name.text.isEmpty() -> name.error = "Name required"
            emailAddress.text.isEmpty() -> emailAddress.error = "Email address required"
            password.text.isEmpty() -> name.error = "Password required"
            name.text.isEmpty() -> name.error = "School required"
            !Patterns.EMAIL_ADDRESS.matcher(emailAddress.text.toString()).matches() ->
                emailAddress.error = "Please enter a valid email" }

        val detailsCollected = getSharedPreferences("detailsCollected", Context.MODE_PRIVATE)
        val collected = detailsCollected.edit()

        when {
            name.text.toString().isNotEmpty() ->  collected.putString("name", editTextName.text.toString())
            emailAddress.text.toString().isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailAddress.text.toString()).matches() ->
                collected.putString("email", editTextEmail.text.toString())
            password.text.toString().isNotEmpty() -> collected.putString("password", editTextPassword.text.toString())
            school.text.toString().isNotEmpty() -> collected.putString("school", editTextSchool.text.toString())
        }
        collected.apply()
        Toast.makeText(this, "Account created!", Toast.LENGTH_LONG).show()
    }
}

