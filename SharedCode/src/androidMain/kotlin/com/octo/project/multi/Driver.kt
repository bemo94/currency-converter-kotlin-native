package com.octo.project.multi

import com.squareup.sqldelight.db.SqlDriver

actual var sqlDriver: SqlDriver? = null

actual fun setupDatabase() {}