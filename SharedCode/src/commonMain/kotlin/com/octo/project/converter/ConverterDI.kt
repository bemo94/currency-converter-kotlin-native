package com.octo.project.converter

import com.octo.project.app.AppDI
import com.octo.project.multi.CoroutineContextSwitcher
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton

class MainDi(displayer: ConverterDisplay) {

    private val kodein = Kodein {

        bind<ConverterRepository>() with singleton {
            ConverterRepositoryImpl()
        }

        bind<ConverterPresenter>() with singleton {
            ConverterPresenterImpl(threadManager = instance(), display = displayer)
        }

        bind() from singleton {
            ConverterInteractor(
                presenter = instance(),
                converterRepository = instance(),
                historyRepository = AppDI.getHistoryRepository()
            )
        }

        bind() from provider {
            CoroutineContextSwitcher.newInstance()
        }

        bind() from singleton {
            ConverterController(threadManager = instance(), interactor = instance())
        }
    }

    fun getController(): ConverterController = kodein.direct.instance()
}
