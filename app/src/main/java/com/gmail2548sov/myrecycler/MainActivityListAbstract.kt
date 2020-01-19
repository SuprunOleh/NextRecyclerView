package com.gmail2548sov.myrecycler

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.security.AccessController.getContext
import java.util.*

abstract class MainActivityListAbstract: AppCompatActivity() {

   abstract fun createFragList ():Fragment

    val mFragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d ("333", savedInstanceState.toString())
        super.onCreate(savedInstanceState)
        Log.d ("333", "${savedInstanceState.toString()}, 2")
        setContentView(R.layout.activity_main)

        val fragment: Fragment? = mFragmentManager.findFragmentById(R.id.container)
        if (fragment == null) {
            mFragmentManager.beginTransaction().add(R.id.container, createFragList()).commit()
        }

    }


}