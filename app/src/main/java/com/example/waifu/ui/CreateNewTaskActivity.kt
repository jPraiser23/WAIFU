package com.example.waifu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.example.waifu.R
import com.example.waifu.dto.Task
import com.example.waifu.PriorityLevel
import kotlinx.android.synthetic.main.activity_create_new_task.*
import kotlinx.android.synthetic.main.activity_create_new_task.view.*

class CreateNewTaskActivity : AppCompatActivity()
{

    var enteredPriorityLevel = PriorityLevel.HIGH.priorityLevelNumber;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_task)

        btnSave.setOnClickListener {
            saveTask()
        }



    }

    fun goBackToHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun determinePriorityLevel(): Int
    {
        val radioGroupPriority = findViewById<RadioGroup>(R.id.rgPriority)
        if(radioGroupPriority.rdoLowPriority.isChecked)
        {
            //priorityLevel = 1
            enteredPriorityLevel = PriorityLevel.LOW.priorityLevelNumber
        }
        if(radioGroupPriority.rdoMediumPriority.isChecked)
        {
            //priorityLevel = 2
            enteredPriorityLevel = PriorityLevel.MEDIUM.priorityLevelNumber
        }
        if(radioGroupPriority.rdoHighPriority.isChecked)
        {
            //priorityLevel = 3
            enteredPriorityLevel = PriorityLevel.HIGH.priorityLevelNumber
        }
        return enteredPriorityLevel
    }
    private fun saveTask()
    {
        var task = Task(etTaskName.text.toString(), etTaskDescription.text.toString(), determinePriorityLevel())

    }
}
