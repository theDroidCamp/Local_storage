package com.olgatech.droidcamptask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {

    lateinit var welcomeTxt: TextView
    lateinit var welcomeTxt1: TextView
    lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        welcomeTxt = findViewById(R.id.hello_txt)
        welcomeTxt1 = findViewById(R.id.click_txt)
        image = findViewById(R.id.get_started_img)


        login_button.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        signup_txt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}