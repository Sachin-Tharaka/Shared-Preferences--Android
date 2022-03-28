package com.sachin.sharedpreferences_androidapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", MODE_PRIVATE)


        saveButton.setOnClickListener{
            val name = name.text.toString().trim()
            val age = Integer.parseInt(age.text.toString().trim())
            val subscribed = switch1.isChecked

            val editor = sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putInt("AGE",age)
            editor.putBoolean("SUBSCRIBE", subscribed)

            editor.apply()
        }

        showInfoButton.setOnClickListener{

            val name = sharedPreferences.getString("NAME","")
            val age = sharedPreferences.getInt("AGE",0)
            val subscribe = sharedPreferences.getBoolean("SUBSCRIBE",false)

            infoShower.text = "Name:\t $name \nAge\t : $age  \nSubscribed to Emailing:\t $subscribe"
        }

    }
}