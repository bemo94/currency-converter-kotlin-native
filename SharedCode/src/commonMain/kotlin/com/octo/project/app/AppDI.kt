package com.octo.project.app

import com.octo.project.history.HistoryRepository
import com.octo.project.multi.setupDatabase
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton
import kotlin.native.concurrent.ThreadLocal

class AppDI {
    @ThreadLocal
    companion object {
        var kodein = Kodein {

            bind() from singleton {
                setupDatabase()
                HistoryRepository()
            }
        }

        fun getHistoryRepository(): HistoryRepository = kodein.direct.instance()
    }
}