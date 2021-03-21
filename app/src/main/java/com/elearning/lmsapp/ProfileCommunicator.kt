package com.elearning.lmsapp

interface ProfileCommunicator {

    fun sendProfileData(name: String, email: String, phone: String)
}