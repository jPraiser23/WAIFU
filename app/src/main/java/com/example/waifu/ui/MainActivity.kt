package com.example.waifu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.waifu.R
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val monthDatePattern = "MMMM d"
//        val yearPattern = "yyyy"
//        tvMonthDay.setText(SimpleDateFormat(monthDatePattern).toString())
//        tvYear.setText(SimpleDateFormat(yearPattern).toString())

    }

    fun goToCreateNewTask(view: View)
    {
        val intent = Intent(this, CreateNewTaskActivity::class.java)
        startActivity(intent)
    }
}
