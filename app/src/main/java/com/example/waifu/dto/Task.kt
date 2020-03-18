package com.example.waifu.dto

data class Task
(
//    var taskList: IntArray,
//    var taskId: Int,
    var taskName: String,
    var taskDescription: String,
    var taskPriorityLevel: Int,
    var taskLocation: Int//,
//    var taskColor: String, //TODO potentially do color changing logic for priority level somewhere else other than this DTO
//    var updatePriority: Boolean,
//    var updateTask: Boolean
)
{
    override fun toString(): String //overrides toString() to give the task's name, priority level, and location on the board
    {
        //return taskName + " (ID: " + taskId + ", Level: " + taskPriorityLevel + ", Location: " + taskLocation + ") "
        return taskName + " (Priority Level: " + taskPriorityLevel + ", Location: " + taskLocation + ") "
    }

    //-------------------------------------------------------------
    //getters
    //-------------------------------------------------------------
//    fun getTaskId(task: Task): Int
//    {
//        return task.taskId;
//    }
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

    fun getTaskLocation(task: Task): Int
    {
        return task.taskLocation;
    }

//    fun getTaskColor(task: Task): String
//    {
//        return task.taskColor;
//    }

    //-------------------------------------------------------------
    //setters
    //-------------------------------------------------------------
//    fun setTaskId(task: Task, newTaskId: Int): Int
//    {
//        if(newTaskId != null)
//        {
//            task.taskPriorityLevel = newTaskPriorityLevel
//        }
//        task.taskId = newTaskId;
//        return task.taskId;
//    }

    fun setTaskName(task: Task, newTaskName: String): String
    {
        if((newTaskName != null) && (newTaskName.isEmpty()))
        {
            task.taskName = newTaskName;
        }
        return task.taskName;
    }

    fun setTaskDescription (task: Task, newTaskDescription: String): String
    {
        if((newTaskDescription != null) && (newTaskDescription.isEmpty()))
        {
            task.taskDescription = newTaskDescription;
        }
        return task.taskDescription;
    }

    fun setTaskPriorityLevel(task: Task, newTaskPriorityLevel: Int): Int
    {
        if(newTaskPriorityLevel != null)
        {
            task.taskPriorityLevel = newTaskPriorityLevel
        }
        return task.taskPriorityLevel;
    }

    fun setTaskLocation(task: Task, newTaskLocation: Int): Int
    {
        if(newTaskLocation != null)
        {
            task.taskLocation = newTaskLocation;
        }
        return task.taskLocation;
    }

//    fun setTaskColor(task: Task, newTaskColor: String): String
//    {
//        if(newTaskColor != null)
//        {
//            task.taskColor = newTaskColor
//        }
//        return task.taskColor;
//    }
    //-------------------------------------------------------------

//    fun createTask(taskName: String, ): Task
//    {
//        if(taskName != null)
//        {
//            tasklist
//        }
//    }
//
//    fun generateTaskId(taskName: String): Int
//    {
//        if(taskName != null)
//        {
//            tasklist
//        }
//    }

//    fun addTaskToTaskList(taskId: Int): IntArray
//    {
//        if(taskId != null) //if the task Id is not null
//        {
//            taskList.plus(taskId)
//        }
//
//        return taskList;
//
//    }

}