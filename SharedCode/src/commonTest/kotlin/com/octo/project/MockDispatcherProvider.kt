package com.octo.project

import com.octo.project.app.DispatchProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MockDispatcherProvider : DispatchProvider() {
    override  val main: CoroutineDispatcher by lazy { Dispatchers.Unconfined}
    override  val background: CoroutineDispatcher by lazy { Dispatchers.Unconfined}
}
