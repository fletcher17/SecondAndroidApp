package com.decadev.a2ndandroid

import android.content.Context
import androidx.preference.PreferenceManager


class ListDataManager(private val context: Context) {

    //the saving method: this saves the list
    fun saveList(list: TaskList) {
        //creating the storage
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context).edit()
    //store the lists and convert the list to a set
        sharedPrefs.putStringSet(list.name, list.tasks.toHashSet())
        sharedPrefs.apply()
    }

    //to read the list, we need to create a read list method
    fun readLists(): ArrayList<TaskList> {
        //first we need a reference to shared prefs
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)

        //we need to get the content of the list from the shared preference: the content contains a map of keys and values
        val contents = sharedPrefs.all

        //Then we create a list(an array list) to hold the taskList
        val taskLists = ArrayList<TaskList>()

        //add a for loop in our readlists() to loop through the keys
        for(taskList in contents) {
            //1st we get the saved hashset and convert it into an arrayList
            val taskItems = ArrayList(taskList.value as HashSet<String>)

            //then create a task list from it
            val list = TaskList(taskList.key, taskItems)

            //Now add it to the Array
            taskLists.add(list)
        }
        return taskLists
    }
}