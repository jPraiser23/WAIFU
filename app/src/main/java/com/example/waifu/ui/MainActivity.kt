package com.example.waifu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.waifu.R
import com.example.waifu.dto.RecyclerViewRowItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.tasks.observe(this, Observer {
            //TODO //spinner population retrofit required (only designed to work with spinner) /update logic
            //tasks -> tskTasks.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, tasks))
        })
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(parent.applicationContext) //TODO check to see if this is right (should be context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        //recyclerView.adapter = RecyclerViewAdapter(viewModel.tasks. //TODO adapter needs to be fixed

    }


    fun goToCreateNewTask(view: View) {
        val intent = Intent(this, CreateNewTaskActivity::class.java)
        startActivity(intent)
        viewModel
    }

    inner class RecyclerViewAdapter(val recyclerViewRowItems: List<RecyclerViewRowItem>, val itemLayout: Int) : RecyclerView.Adapter<MainActivity.RecyclerViewViewHolder>() {
        /**
         * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
         * an item.
         *
         *
         * This new ViewHolder should be constructed with a new View that can represent the items
         * of the given type. You can either create a new View manually or inflate it from an XML
         * layout file.
         *
         *
         * The new ViewHolder will be used to display items of the adapter using
         * [.onBindViewHolder]. Since it will be re-used to display
         * different items in the data set, it is a good idea to cache references to sub views of
         * the View to avoid unnecessary [View.findViewById] calls.
         *
         * @param parent The ViewGroup into which the new View will be added after it is bound to
         * an adapter position.
         * @param viewType The view type of the new View.
         *
         * @return A new ViewHolder that holds a View of the given view type.
         * @see .getItemViewType
         * @see .onBindViewHolder
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder
        {
            val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
            return RecyclerViewViewHolder(view)

        }

        /**
         * Returns the total number of items in the data set held by the adapter.
         *
         * @return The total number of items in this adapter.
         */
        override fun getItemCount(): Int {
            return recyclerViewRowItems.size
        }

        /**
         * Called by RecyclerView to display the data at the specified position. This method should
         * update the contents of the [ViewHolder.itemView] to reflect the item at the given
         * position.
         *
         *
         * Note that unlike [android.widget.ListView], RecyclerView will not call this method
         * again if the position of the item changes in the data set unless the item itself is
         * invalidated or the new position cannot be determined. For this reason, you should only
         * use the `position` parameter while acquiring the related data item inside
         * this method and should not keep a copy of it. If you need the position of an item later
         * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
         * have the updated adapter position.
         *
         * Override [.onBindViewHolder] instead if Adapter can
         * handle efficient partial bind.
         *
         * @param holder The ViewHolder which should be updated to represent the contents of the
         * item at the given position in the data set.
         * @param position The position of the item within the adapter's data set.
         */
        override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
            val rowItemPosition = recyclerViewRowItems.get(position)
            holder.updateRecyclerView(rowItemPosition)
        }
    }

    inner class RecyclerViewViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        private var lblTaskName : TextView = itemView.findViewById(R.id.lblTaskName)
        private var lblTaskDescription : TextView = itemView.findViewById(R.id.lblTaskDescription)
        private var lblTaskPriorityLevel : TextView = itemView.findViewById(R.id.lblTaskPriorityLevel)

        //this will add each row from each item in the collection that needs to display in the recyclerView
        fun updateRecyclerView(rowItem : RecyclerViewRowItem)
        {
            lblTaskName.text = rowItem.toString() //TODO fix this (adding a text getter for each string)n
        }

    }

}
