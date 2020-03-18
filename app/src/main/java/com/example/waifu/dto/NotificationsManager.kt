package com.example.waifu.dto

import java.util.*

data class NotificationsManager
(
    var notificationMessage: String,
    var notificationFrequency: Timer
)
{
    //-------------------------------------------------------------
    //getters
    //-------------------------------------------------------------
    fun getNotificationMessage(task: Task): String
    {
        return notificationMessage;
    }

    fun getNotificationFrequency(task: Task): Timer
    {
        return notificationFrequency;
    }

    //-------------------------------------------------------------
    //setters
    //-------------------------------------------------------------
    fun setNotificationMessage(task: Task, newNotificationMessage: String): String {
        if ((task.notificationSettingsEnabled) && (newNotificationMessage != null) && (newNotificationMessage.isEmpty()) && (!(newNotificationMessage.equals(
                task.taskDescription
            )))
        ) {
            notificationMessage = newNotificationMessage;
        }
        return notificationMessage
    }

    fun setNotificationFrequency(task: Task, newNotificationFrequency: Timer): Timer //TODO may need to be retooled or revised
    {
        if ((task.notificationSettingsEnabled) && (newNotificationFrequency != null))
        {
            notificationFrequency = newNotificationFrequency
        }
        return notificationFrequency
    }
}