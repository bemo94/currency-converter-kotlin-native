package com.octo.project.history

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.octo.project.History
import com.octo.project.R
import com.octo.project.converter.MainActivity
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity(), HistoryDisplay {

    private val historyDi: HistoryDi by lazy { HistoryDi(this) }
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val controller: HistoryController by lazy {
        historyDi.getHistoryController()
    }

    override fun displayHistory(history: MutableList<History>?) {
        historyView.adapter = history?.let { HistoryAdapter(it, this@HistoryActivity) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        linearLayoutManager = LinearLayoutManager(this)
        historyView.layoutManager = linearLayoutManager

        controller.loadHistory()

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}