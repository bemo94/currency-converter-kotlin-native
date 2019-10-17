package com.octo.project

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        sqlDriver = AndroidSqliteDriver(SqlDelightDatabase.Schema, applicationContext, "history.db")
    }
}