package com.example.catsanddogs

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.catsanddogs.models.User
import com.google.gson.Gson

class UserStorage(private val context: Context){

    companion object{
        const val USER = "user"
    }

    private val gson = Gson()

    private fun getSharedPreference(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setUser(user: User){
        getSharedPreference(context).edit().putString(USER, gson.toJson(user, User::class.java)).apply()
    }

    fun getUser() : User?{
        val userInJson = getSharedPreference(context).getString(USER, null) ?: return null
        return gson.fromJson(userInJson, User::class.java)
    }

    fun delUser(){
        getSharedPreference(context).edit().remove(USER).apply()
    }
}
