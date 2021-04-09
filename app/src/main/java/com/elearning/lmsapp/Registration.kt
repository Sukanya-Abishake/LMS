package com.elearning.lmsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.elearning.model.User
import com.elearning.restcall.Api
import com.elearning.restcall.RetrofitClient
import com.elearning.util.ValidationUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Registration : AppCompatActivity() {
    private var role: String = "Student"
    lateinit var btSubmit: Button
    val TAG: String = "Registration"
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etpassword: EditText
    lateinit var etCity: EditText
    lateinit var etAddress: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etPincode: EditText
    lateinit var name: String
    lateinit var phoneNumber: String
    lateinit var email: String
    private var address: String = ""
    private var pincode: String = ""
    private var password: String = ""
    private var city: String = ""
    lateinit var radioRoleGroup: RadioGroup
    lateinit var radioRoleButton: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(findViewById(R.id.toolbar))

        btSubmit = findViewById<Button>(R.id.bt_submit)
        etName = findViewById(R.id.et_username)
        etEmail = findViewById(R.id.et_email)
        etpassword = findViewById(R.id.et_password)
        etPhoneNumber = findViewById(R.id.et_phone)
        etPincode = findViewById(R.id.et_pincode)
        etCity = findViewById(R.id.et_city)
        etAddress = findViewById(R.id.et_address)
        radioRoleGroup = findViewById(R.id.rg_usertype)

        btSubmit.setOnClickListener {
            name = etName.text.toString()
            phoneNumber = etPhoneNumber.text.toString()
            email = etEmail.text.toString()
            address = etAddress.text.toString()
            pincode = etPincode.text.toString()
            password = etpassword.text.toString()
            city = etCity.text.toString()

            radioRoleGroup.setOnCheckedChangeListener { group, checkedId ->
                radioRoleButton = findViewById(checkedId)
                role = radioRoleButton.text.toString()
            }

            Log.i(TAG, "role::" + role + "***")
            if (isValidateRegistrationFields()) {
                saveUser()
            }
        }
    }

    private fun onHome() {
        val homeScreen = Intent(this, HomeActivity::class.java)
        startActivity(homeScreen)
        finish()
    }

    private fun storeData() {
        val sharedPreferences = getSharedPreferences("LMSPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putString("username", etEmail.getText().toString())
        myEdit.putString("password", etpassword.getText().toString())
        myEdit.commit()
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
        Log.d(TAG, "isValidData::" + isValidData)
        return isValidData
    }


    fun saveUser() {
        val myApi: Api = RetrofitClient.getInstance().getMyApi()
        val user = User(name, phoneNumber, email, address, pincode, password, city, "student")

        val userCall: Call<User> = myApi.saveData(user)
        userCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.i(TAG, "post " + response.body().toString())
                if (response.isSuccessful()) {
                    //showResponse(response.body().toString());
                    storeData()
                    onHome()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e(TAG, "Unable to submit post to API.$t")
            }
        })
    }
}