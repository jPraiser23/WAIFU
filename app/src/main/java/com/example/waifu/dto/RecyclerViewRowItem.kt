package com.example.waifu.dto


data class RecyclerViewRowItem
(
    var taskName: String,
    var taskDescription: String,
    var taskPriorityLevel: Int
)
{
    override fun toString(): String
    {
        return "$taskName $taskDescription $taskPriorityLevel"
    }
}