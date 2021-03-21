package com.elearning.util;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class ValidationUtil {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");

    private static  final Pattern PHONENUMBER_PATTERN = Pattern.compile("^\\+[0-9]{1,10}$");


    public static final String EMAIL_REGEX_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password) && PASSWORD_PATTERN.matcher(password).matches();
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return !TextUtils.isEmpty(phoneNumber) && PHONENUMBER_PATTERN.matcher(phoneNumber).matches();
    }

}
