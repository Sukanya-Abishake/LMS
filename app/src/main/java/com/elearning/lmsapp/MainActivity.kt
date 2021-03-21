package com.elearning.lmsapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ProfileCommunicator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val btRegister = findViewById<Button>(R.id.bt_register);
        val btLogin = findViewById<Button>(R.id.bt_login);
        btRegister.setOnClickListener {
            val registration = Intent(this, Registration::class.java)
            startActivity(registration);
        }

        btLogin.setOnClickListener {
            exit();
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

    fun exit() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Successfully login..!!!")
        // Icon Of Alert Dialog
        //alertDialogBuilder.setIcon(R.drawable.question);
        // Setting Alert Dialog Message
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.setPositiveButton("Ok") { arg0, arg1 ->
            onHomeScreen()
            finish()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }


    fun onHomeScreen() {
        val homeScreen = Intent(this, HomeActivity::class.java)
        startActivity(homeScreen)
    }

    override fun sendProfileData(name: String, email: String, phone: String) {
            val bundle=Bundle()
        bundle.putString("name", name)
        bundle.putString("email", email)
        bundle.putString("phone", phone) ;
        val transaction=this.supportFragmentManager.beginTransaction();
        val dashboard=DashboardFragment.newInstance(name, email, phone)
        dashboard.arguments=bundle
        // Replace the contents of the container with the new fragment
        transaction.replace(R.id.body_content, dashboard).commit()


    }


}