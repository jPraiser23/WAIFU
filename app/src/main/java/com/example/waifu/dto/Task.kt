package com.example.waifu.dto

data class Task
(
    var taskName: String,
    var taskDescription: String,
    var taskPriorityLevel: Int,
    var taskId: String
)
{
    //-------------------------------------------------------------
    //override methods
    //-------------------------------------------------------------
    override fun toString(): String //overrides toString() to give the task's name, priority level, and location on the board
    {
        return taskName + " (Priority Level: " + taskPriorityLevel + ") ";
    }

    //-------------------------------------------------------------
    //getters
    //-------------------------------------------------------------
    fun getTaskName(task: Task): String
    {
        return task.taskName;
    }

    fun getTaskDescription (task: Task): String
    {
        return task.taskDescription;
    }

    fun getTaskPriorityLevel(task: Task): Int
    {
        return task.taskPriorityLevel;
    }

    //-------------------------------------------------------------
    //setters
    //-------------------------------------------------------------
    fun setTaskName(task: Task, newTaskName: String): String
    {
        if((newTaskName != null) && (newTaskName.isEmpty()) && (!(newTaskName.equals(task.taskName))))
        {
            task.taskName = newTaskName;
        }
        return task.taskName;
    }

    fun setTaskDescription (task: Task, newTaskDescription: String): String
    {
        if((newTaskDescription != null) && (newTaskDescription.isEmpty()) && (!(newTaskDescription.equals(task.taskDescription))))
        {
            task.taskDescription = newTaskDescription;
        }
        return task.taskDescription;
    }

    fun setTaskPriorityLevel(task: Task, newTaskPriorityLevel: Int): Int
    {
        if((newTaskPriorityLevel != null) && (newTaskPriorityLevel > 0) && (newTaskPriorityLevel != task.taskPriorityLevel))
        {
            task.taskPriorityLevel = newTaskPriorityLevel
        }
        return task.taskPriorityLevel;
    }

/*    fun setTaskLocation(task: Task, newTaskLocation: Int): Int
    {
        if((newTaskLocation != null) && (newTaskLocation > 0) && (newTaskLocation != task.taskLocation))
        {
            task.taskLocation = newTaskLocation;
        }
        return task.taskLocation;
    }

    fun setNotificationSettings(task: Task, changedNotificationSettings: Boolean): Boolean
    {
        if(task.notificationSettingsEnabled != changedNotificationSettings)
        {
            task.notificationSettingsEnabled = changedNotificationSettings;
        }
        return task.notificationSettingsEnabled;
    }*/
}