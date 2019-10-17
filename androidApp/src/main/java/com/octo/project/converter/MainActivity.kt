package com.octo.project.converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.octo.project.HistoryRepository
import com.octo.project.R
import com.octo.project.getDummyString
import com.octo.project.setupDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = getDummyString()
        setupDatabase()
        val database: HistoryRepository =  HistoryRepository()
    }
}