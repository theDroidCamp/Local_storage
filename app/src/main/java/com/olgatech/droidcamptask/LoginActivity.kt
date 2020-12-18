package com.olgatech.droidcamptask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.login_activity.login_button

class LoginActivity: AppCompatActivity() {

    lateinit var editTxtEmail: EditText
    lateinit var  editTxtPassword:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        editTxtEmail = editTextEmailAddress
        editTxtPassword = editTextPassword
        retrieveData()
        login_button.setOnClickListener {
            storeData()

        }
    }

    private fun retrieveData() {
        val myPref = getSharedPreferences("dataRetrieved", Context.MODE_PRIVATE)
        val email= myPref.getString("email", "")
        val password = myPref.getString("password", "")

        editTextEmailAddress.setText(email)
        editTextPassword.setText(password)
    }

    private fun storeData() {
        if (editTxtEmail.text.isEmpty()) {
            editTxtEmail.error = "Enter your email address"
            editTxtEmail.requestFocus()
            return }

        else if (editTxtPassword.text.isEmpty()) {
            editTxtPassword.error = "Enter your password"
            editTxtPassword.requestFocus()
            return }

        val myPref = getSharedPreferences("dataSupplied", Context.MODE_PRIVATE)
        val editor = myPref.edit()

        editor.putString("email", editTxtEmail.text.toString())
        editor.putString("password", editTxtPassword.text.toString())
        editor.apply()
        Toast.makeText(this, "Saved!",Toast.LENGTH_LONG).show()
        val intent = Intent(this, UserDetailActivity::class.java)
            startActivity(intent)
            finish()
//        val userEmail = myPref.getString("email", "")
//        val userPassword = myPref.getString("password", "")
//
//        if (userEmail!! == editTxtEmail.text.toString() && userPassword!! == editTxtPassword.text.toString()) {
//             }
//        else{ Toast.makeText(this, "Wrong email or Password",Toast.LENGTH_LONG).show() }
    }


}
