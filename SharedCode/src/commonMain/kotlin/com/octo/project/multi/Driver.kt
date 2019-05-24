package com.octo.project.multi

import com.squareup.sqldelight.db.SqlDriver

expect var sqlDriver: SqlDriver?
expect fun setupDatabase()