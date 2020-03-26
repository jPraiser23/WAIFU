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

//Firebase Gmail Account: projectteamwaifu@gmail.com
class LoginActivity : AppCompatActivity()
{
    private val AUTH_REQUEST_CODE = 2002; //set for firebase authentication logic
    private var user : FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener()
        {
            login()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) //watch videos to expand upon this more
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTH_REQUEST_CODE) //called when the user submits login information
        {
            user = FirebaseAuth.getInstance().currentUser //gets user
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) //brings user to the main activity screen
        }
    }

    private fun login()//pulls up firebase login screen UI
    {
        var providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(), AUTH_REQUEST_CODE)
    }
}
