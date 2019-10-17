package com.octo.project.converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.octo.project.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDatabase()

        val database =  StringRepository()
        database.addString("string1")
        database.addString("string2")
        database.addString("string3")

        val strings = database.getStrings()
        var result = ""

        if (strings != null) {
            for (string in strings) {
                result += string
            }
        }

        textView.text = result
    }
}