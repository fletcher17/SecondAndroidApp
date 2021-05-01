package com.decadev.a2ndandroid

import android.os.Bundle
import android.text.InputType
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var todoListRecyclerView: RecyclerView
    //now we can call the listdatamanager class
    val listDataManager: ListDataManager = ListDataManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        //This reads the list
        val lists = listDataManager.readLists()

        todoListRecyclerView = findViewById(R.id.recycler_layout)
        todoListRecyclerView.layoutManager =
            LinearLayoutManager(this)
        todoListRecyclerView.adapter = TodoListAdapter(lists)



        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { _ ->
            showCreateTodoListDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateTodoListDialog() {
        var dialogTitle = "Create New Contact"
        var positiveButtonTitle = "Add Contact"
        var myDialog = AlertDialog.Builder(this)

        var todoTitleEditText = EditText(this)
        todoTitleEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS

        myDialog.setTitle(dialogTitle)
        myDialog.setView(todoTitleEditText)



        myDialog.setPositiveButton(positiveButtonTitle) {dialog, _->
            val adapter = todoListRecyclerView.adapter as TodoListAdapter
            //here, we create an empty task list passing in the edit text as the title and save it
            val list = TaskList(todoTitleEditText.text.toString())
            listDataManager.saveList(list)
            //we want to update the recycler view, so we save the list in the adapter
            adapter.addList(list)
            dialog.dismiss()
        }

        myDialog.create().show()
    }


}

//adapter.addNewItem(todoTitleEditText.text.toString())