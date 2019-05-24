package com.octo.project.converter

import com.octo.project.app.AppDI
import com.octo.project.app.DispatchProvider
import com.octo.project.app.LocalRepository
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton

class MainDi {

    private lateinit var kodein: Kodein

    fun getMainController(displayer: ConverterDisplay): ConverterController {

        kodein = Kodein {

            bind<ConverterRepositoryImpl>("repository") with provider {
                ConverterRepositoryImpl()
            }

            bind<ConverterPresenterImpl>("presenter") with provider {
                val display: ConverterDisplay = displayer
                val provider by AppDI.kodein.instance<DispatchProvider>("provider")
                ConverterPresenterImpl(provider, display)
            }

            bind<ConverterInteractor>("interactor") with provider {
                val repository by kodein.instance<ConverterRepositoryImpl>("repository")
                val repository2: LocalRepository by  AppDI.kodein.instance("repository")
                val presenter by kodein.instance<ConverterPresenterImpl>("presenter")
                ConverterInteractor(presenter, repository, repository2)
            }

            bind<ConverterController>("controller") with singleton {
                val interactor by kodein.instance<ConverterInteractor>("interactor")
                val provider by AppDI.kodein.instance<DispatchProvider>("provider")
                ConverterController(provider, interactor)
            }
        }

        val leaderboardController: ConverterController by kodein.instance("controller")
        return leaderboardController
    }

}