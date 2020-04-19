package com.example.waifu.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waifu.dto.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class MainViewModel : ViewModel()
{
    private lateinit var firestore: FirebaseFirestore
    private var _tasks: MutableLiveData<ArrayList<Task>> = MutableLiveData<ArrayList<Task>>()
    init
    {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
        listenToTasks()
    }

    /**
     * This will hear any updates from firestore
     */
    private fun listenToTasks()
    {
        firestore.collection("tasks").addSnapshotListener()
        {
            snapshot, e ->
            //if there is an exception, skip
            if(e !=null)
            {
                Log.w(TAG, "Listen failed", e)
                return@addSnapshotListener
            }
            //if there is no exception
            {
                if(snapshot != null)
                {
                    //populate snapshot
                    val taskList = ArrayList<Task>()
                    val documents = snapshot.documents
                    documents.forEach()
                    {
                        val task = it.toObject(Task::class.java) //convert it to Task object
                        if (task != null)
                        {
                            taskList.add(task!!) //if task is not null, add it to the task list.
                        }
                    }
                    _tasks.value = taskList
                }
            }
        }
    }

    fun save(task: Task)
    {
        val document = firestore.collection("tasks").document()
        task.taskId = document.id
        val set = document.set(task)
            set.addOnSuccessListener {
                Log.d("Firebase", "Document saved")
            }
            set.addOnFailureListener() {
                Log.d("Firebase", "Save failed")
            }
    }

    internal var tasks:MutableLiveData<ArrayList<Task>>
        get() { return _tasks }
        set(value) {_tasks = value}
}