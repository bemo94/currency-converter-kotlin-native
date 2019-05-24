package com.octo.project.multi

import com.octo.project.SqlDelightDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.ios.NativeSqliteDriver

actual var sqlDriver: SqlDriver? = null

actual fun setupDatabase() {
    sqlDriver = NativeSqliteDriver(SqlDelightDatabase.Schema, "history.db")
}