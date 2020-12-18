package com.olgatech.droidcamptask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_dets.*
import kotlinx.android.synthetic.main.user_details.*

class UserDetailActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var emailAddress : TextView
    private lateinit var  school : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dets)

        name = name_txt
        emailAddress = email_txt
        school = school_txt
        showDetails()

        logout_button.setOnClickListener {
            saveData()
        }

    }

    private fun saveData() {
        if (name.text.isEmpty()){
            name.error = "Enter your Name"
            return
        }

        if (emailAddress.text.isEmpty()){
            emailAddress.error = "Enter your E-mail address"
            return
        }

        if (school.text.isEmpty()){
            school.error = "Enter your school name"
            return
        }

        val saveData = getSharedPreferences("savedData", Context.MODE_PRIVATE)
        val editor  = saveData.edit()

        editor.putString("name", name.text.toString())
        editor.putString("email", emailAddress.text.toString())
        editor.putString("school", school.text.toString())

        editor.apply()
        Toast.makeText(this, "Details Saved!", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun showDetails() {
        val detailsDisplayed = getSharedPreferences("detailsDisplayed", Context.MODE_PRIVATE)

        val currentName = detailsDisplayed.getString("name", "")
        name.text = currentName
        val currentEmailAddress= detailsDisplayed.getString("email", "")
        emailAddress.text = currentEmailAddress
        val currentSchool  = detailsDisplayed.getString("school", "")
        school.text = currentSchool
    }
}