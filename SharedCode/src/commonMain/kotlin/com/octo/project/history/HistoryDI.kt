package com.octo.project.history

import com.octo.project.app.AppDI
import com.octo.project.multi.CoroutineContextSwitcher
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton

class HistoryDi(displayer: HistoryDisplay) {

    private val kodein = Kodein {

        bind<HistoryPresenter>() with singleton {
            HistoryPresenterImpl(threadManager = instance(), display = displayer)
        }

        bind() from singleton {
            HistoryInteractor(presenter = instance(), repository = AppDI.getHistoryRepository())
        }

        bind() from provider {
            CoroutineContextSwitcher.newInstance()
        }

        bind() from singleton {
            HistoryController(threadManager = instance(), interactor = instance())
        }
    }

    fun getHistoryController(): HistoryController = kodein.direct.instance()
}