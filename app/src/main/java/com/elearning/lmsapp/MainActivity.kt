package com.elearning.lmsapp

import android.R.attr.name
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.elearning.util.ValidationUtil


class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    lateinit var etEmail: EditText
    lateinit var etpassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        etEmail = findViewById(R.id.username)
        etpassword = findViewById(R.id.password)
        val tvErrormessage = findViewById<TextView>(R.id.tv_errormessage)
        val btRegister = findViewById<Button>(R.id.bt_register);
        val btLogin = findViewById<Button>(R.id.bt_login);
        btRegister.setOnClickListener {
            val registration = Intent(this, Registration::class.java)
            startActivity(registration)
        }

        btLogin.setOnClickListener {
            if (isValidateLoginInfoFields())
                exit()
            else {
                tvErrormessage.text = "Please correct the invalid fields"
                tvErrormessage.visibility = View.VISIBLE

            }


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun isValidateLoginInfoFields(): Boolean {
        var isValidData = true

        if (!ValidationUtil.isValidEmail(etEmail.text.toString())) {
            isValidData = false
            etEmail.isActivated = true
        }
        if (!ValidationUtil.isValidPassword(etpassword.text.toString())) {
            Log.d(TAG, "password is not valid::::" + etpassword.text.toString())
            isValidData = false
            etpassword.isActivated = true
        }
        return isValidData
    }

    private fun exit() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Successfully login..!!!")
        // Icon Of Alert Dialog
        //alertDialogBuilder.setIcon(R.drawable.question);
        // Setting Alert Dialog Message
        //alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.setPositiveButton("Ok") { arg0, arg1 ->
            Log.d(TAG, "Login Buttin Pressed")
            storeData()
            onHomeScreen()
            finish()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun storeData() {
        val sharedPreferences = getSharedPreferences("LMSPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putString("username", etEmail.getText().toString())
        myEdit.putString("password", etpassword.getText().toString())
        myEdit.commit()
    }


    private fun onHomeScreen() {
        val homeScreen = Intent(this, HomeActivity::class.java)
        startActivity(homeScreen)
    }


}