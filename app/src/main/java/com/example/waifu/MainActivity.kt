package com.example.waifu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        val redColor = Color.parseColor("#FF0000")
        listView.setBackgroundColor(redColor)
    }
//        listView.adapter =  CustomAdapter()
    }

//    private class CustomAdapter:BaseAdapter(){
//        override fun getCount(): Int {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//
//        override fun getItemId(position: Int): Long {
//            return position.toLong()
//        }
//
//        override fun getItem(position: Int): Any {
//        return position.toString()
//        }
//
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//    }
}
