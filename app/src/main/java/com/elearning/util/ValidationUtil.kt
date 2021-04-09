package com.elearning.util

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern

object ValidationUtil {
    private val PASSWORD_PATTERN = Pattern.compile(
        "^" +
                "(?=.*[@#$%^&+=])" +  // at least 1 special character
                "(?=\\S+$)" +  // no white spaces
                ".{4,}" +  // at least 4 characters
                "$"
    )
    private val PHONENUMBER_PATTERN = Pattern.compile("^[0-9]{1,10}$")
    const val EMAIL_REGEX_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    @JvmStatic
    fun isValidPassword(password: String?): Boolean {
        return !TextUtils.isEmpty(password) && PASSWORD_PATTERN.matcher(password).matches()
    }

    @JvmStatic
    fun isValidEmail(email: String?): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPhoneNumber(phoneNumber: String?): Boolean {
        return !TextUtils.isEmpty(phoneNumber) && PHONENUMBER_PATTERN.matcher(phoneNumber).matches()
    }
}