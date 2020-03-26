package com.example.waifu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.waifu.R
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity()
{
    private val AUTH_REQUEST_CODE = 2002; //set for firebase authentication logic
    private var user : FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tvLoginStatus.setText(""); //set login status to an empty string when the app is started up
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) //watch videos to expand upon this more
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTH_REQUEST_CODE)
        {
            user = FirebaseAuth.getInstance().currentUser //gets user
        }
    }

    //TODO replace this function with firebase authentication in the future, or integrate the two
    private fun loginHandler(view: View) //handles logins
    {
        var providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(), AUTH_REQUEST_CODE)
//        var successfulLogin = false
//        if
//        (
//            txtUserName.text.toString().equals("admin") //checks to see if the test username is entered
//            && txtPassword.text.toString().equals("WAIFU") //checks to see if the test password is entered
//        )
//        {
//            //if login is successful, go to the main activity screen
//            successfulLogin = true
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent) //brings user to the main activity screen
//            tvLoginStatus.setText("")
//        }
//        else
//        {
//            //otherwise, display error message
//            successfulLogin = false
//            tvLoginStatus.setText("Login was unsuccessful. Please try this again.")
//        }
    }
}
