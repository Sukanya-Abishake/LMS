package com.elearning.model

class User {
    var id = 0
    var name: String? = null
    var phone: String? = null
    var email: String
    var address: String? = null
    var pincode: String? = null
    var password: String
    var city: String? = null
    var role: String

    constructor(email: String, password: String, role: String) {
        this.email = email
        this.password = password
        this.role = role
    }

    constructor(
        name: String?,
        phone: String?,
        email: String,
        address: String?,
        pincode: String?,
        password: String,
        city: String?,
        role: String
    ) {
        this.name = name
        this.phone = phone
        this.email = email
        this.address = address
        this.pincode = pincode
        this.password = password
        this.city = city
        this.role = role
    }

    override fun toString(): String {
        return "User{" +
                "email=" + email +
                ", password=" + password +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}'
    }
}