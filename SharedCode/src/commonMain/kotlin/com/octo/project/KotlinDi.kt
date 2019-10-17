package com.octo.project

import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton

class KotlinDi(displayer: Displayer) {

    private val kodein = Kodein {

        bind<IntRepository>() with singleton {
            IntRepositoryImpl()
        }

        bind<StringRepository>() with singleton {
            StringRepositoryImpl()
        }

        bind() from provider {
            Presenter(instance(), instance(), displayer)
        }
    }

    fun getPresenter(): Presenter = kodein.direct.instance()
}