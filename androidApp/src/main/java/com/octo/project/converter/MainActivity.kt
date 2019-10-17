package com.octo.project.converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.octo.project.Displayer
import com.octo.project.R

class MainActivity : AppCompatActivity(), Displayer {
    override fun display(string: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}