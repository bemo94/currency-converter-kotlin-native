package com.octo.project

import com.squareup.sqldelight.db.SqlDriver

actual var sqlDriver: SqlDriver? = null

actual fun setupDatabase() {}