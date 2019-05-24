package com.octo.project.app

import com.octo.project.multi.setupDatabase
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.singleton
import kotlin.native.concurrent.ThreadLocal

class AppDI {
    @ThreadLocal companion object {
        var kodein =  Kodein {

            bind<DispatchProvider>("provider") with singleton {
                DispatchProvider()
            }

            bind<LocalRepository>("repository") with singleton {
                setupDatabase()
                LocalRepository()
            }
        }
    }
}