package com.example.waifu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.waifu.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tvLoginStatus.setText(""); //set login status to an empty string when the app is started up
    }

    //TODO replace this function with firebase authentication in the future, or integrate the two
    fun loginHandler(view: View) //handles logins
    {
        var successfulLogin = false
        if
        (
            txtUserName.text.toString().equals("admin") //checks to see if the test username is entered
            && txtPassword.text.toString().equals("WAIFU") //checks to see if the test password is entered
        )
        {
            //if login is successful, go to the main activity screen
            successfulLogin = true
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) //brings user to the main activity screen
            tvLoginStatus.setText("")
        }
        else
        {
            //otherwise, display error message
            successfulLogin = false
            tvLoginStatus.setText("Login was unsuccessful. Please try this again.")
        }
    }
}
