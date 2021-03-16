package com.elearning.lmsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(findViewById(R.id.toolbar))

        val btSubmit = findViewById<Button>(R.id.bt_submit);

        btSubmit.setOnClickListener {
            val homeScreen = Intent(this,HomeActivity::class.java)
            startActivity(homeScreen);
        }


    }
}