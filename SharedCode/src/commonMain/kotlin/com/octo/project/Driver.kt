package com.octo.project

import com.squareup.sqldelight.db.SqlDriver

expect var sqlDriver: SqlDriver?
expect fun setupDatabase()