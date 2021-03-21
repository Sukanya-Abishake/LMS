package com.elearning.lmsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.elearning.util.ValidationUtil

class Registration : AppCompatActivity() {
    val TAG: String = "Registration"
    lateinit var textView: TextView
    lateinit var etEmail: EditText
    lateinit var etpassword: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etPincode: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(findViewById(R.id.toolbar))

        val btSubmit = findViewById<Button>(R.id.bt_submit);
        etEmail = findViewById(R.id.et_email)
        etpassword = findViewById(R.id.et_password)
        etPhoneNumber = findViewById(R.id.et_phone)
        etPincode = findViewById(R.id.et_pincode)


        btSubmit.setOnClickListener {
            if (isValidateRegistrationFields()) {
                val homeScreen = Intent(this, HomeActivity::class.java)
                startActivity(homeScreen)
            }

        }


    }

    private fun isValidateRegistrationFields(): Boolean {
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
        if (!ValidationUtil.isValidPhoneNumber(etPhoneNumber.text.toString())) {
            Log.d(TAG, "PhoneNumber is not valid::::" + etPhoneNumber.text.toString())
            isValidData = false
            etPhoneNumber.isActivated = true
        }
        return isValidData
    }
}