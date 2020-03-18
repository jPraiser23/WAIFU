package com.example.waifu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun goToCreateNewTask(view: View) {
        val intent = Intent(this, CreateNewTaskActivity::class.java)
        startActivity(intent)
    }


}
