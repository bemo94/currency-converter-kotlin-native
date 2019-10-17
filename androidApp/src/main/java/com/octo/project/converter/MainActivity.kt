package com.octo.project.converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.octo.project.Displayer
import com.octo.project.KotlinDi
import com.octo.project.Presenter
import com.octo.project.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Displayer {

    override fun display(string: String) {
        textView.text = string
    }

    private val kotlinDi: KotlinDi by lazy {
        KotlinDi(this)
    }

    private val presenter: Presenter by lazy {
        kotlinDi.getPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.presentConcat()
    }
}