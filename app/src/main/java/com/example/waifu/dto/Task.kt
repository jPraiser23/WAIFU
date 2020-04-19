package com.example.waifu.dto

import com.example.waifu.PriorityLevel

data class Task (var taskName: String = "", var taskDescription: String = "", var taskPriorityLevel: Int = 0, var taskId: String = "")
{
    override fun toString(): String //overrides toString() to give the task's name, priority level, and location on the board
    {
        return taskName + " (Priority Level: " + taskPriorityLevel + ") ";
    }

    @JvmName("getTaskNameFunKotlin")
    fun getTaskName(): String
    {
        return taskName
    }

    @JvmName("getTaskDescriptionKotlin")
    fun getTaskDescription(): String
    {
        return taskDescription
    }

    @JvmName("getTaskPriorityLevelKotlin")
    fun getTaskPriorityLevel(): Int
    {
        return taskPriorityLevel
    }

    fun getTaskPriorityLevelMessage(): String
    {
        var taskPriorityLevelMessage = ""
        if(taskPriorityLevel == PriorityLevel.HIGH.priorityLevelNumber)
        {
            taskPriorityLevelMessage = "High"
        }
        else if(taskPriorityLevel == PriorityLevel.MEDIUM.priorityLevelNumber)
        {
            taskPriorityLevelMessage = "Medium"
        }
        else if(taskPriorityLevel == PriorityLevel.HIGH.priorityLevelNumber)
        {
            taskPriorityLevelMessage = "Low"
        }
        else
        {
            taskPriorityLevelMessage = "Priority Level Not Set"
        }
        return taskPriorityLevelMessage
    }

    fun setTaskName(newTaskName: String): String
    {
        this.taskName = newTaskName
        return taskName
    }

    fun setTaskDescription (newTaskDescription: String): String
    {
        this.taskDescription = newTaskDescription
        return taskDescription
    }

    fun setTaskPriorityLevel(newTaskPriorityLevel: Int): Int
    {
        this.taskPriorityLevel = newTaskPriorityLevel
        return taskPriorityLevel
    }
}