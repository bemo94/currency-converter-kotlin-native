package com.octo.project.history

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.octo.project.History
import com.octo.project.R
import com.octo.project.converter.*
import kotlinx.android.synthetic.main.activity_history.*
import javax.inject.Singleton

class HistoryActivity : AppCompatActivity(), HistoryDisplay {

    @Singleton
    lateinit var di: HistoryDi

    override fun displayHistory(history: MutableList<History>?) {
        historyView.adapter = history?.let { HistoryAdapter(it, this) }
    }

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var controller: HistoryController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        linearLayoutManager = LinearLayoutManager(this)
        historyView.layoutManager = linearLayoutManager
        di = HistoryDi()
        controller = di.getHistoryController(this)

        controller.loadHistory()

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}