package com.octo.project.history

import com.octo.project.app.AppDI
import com.octo.project.app.DispatchProvider
import com.octo.project.app.LocalRepository
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton

class HistoryDi {

    private lateinit var kodein: Kodein

    fun getHistoryController(displayer: HistoryDisplay): HistoryController {

        kodein = Kodein {

            bind<HistoryPresenterImpl>("presenter") with provider {
                val display: HistoryDisplay = displayer
                val provider by AppDI.kodein.instance<DispatchProvider>("provider")
                HistoryPresenterImpl(provider, display)
            }

            bind<HistoryInteractor>("interactor") with provider {
                val repository: LocalRepository by  AppDI.kodein.instance("repository")
                val presenter by kodein.instance<HistoryPresenterImpl>("presenter")
                HistoryInteractor(presenter, repository)
            }

            bind<HistoryController>("controller") with singleton {
                val interactor by kodein.instance<HistoryInteractor>("interactor")
                val provider by AppDI.kodein.instance<DispatchProvider>("provider")
                HistoryController(provider, interactor)
            }
        }

        val leaderboardController: HistoryController by kodein.instance("controller")
        return leaderboardController
    }

}