package com.example.waifu.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waifu.dto.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class MainViewModel : ViewModel()
{
    private lateinit var firestore: FirebaseFirestore
    init
    {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun save(task: Task)
    {
        firestore.collection("tasks")
            .document()
            .set(task)
            .addOnSuccessListener {
                Log.d("Firebase", "Document saved")
            }
            .addOnFailureListener() {
                Log.d("Firebase", "Save failed")
            }
    }
}