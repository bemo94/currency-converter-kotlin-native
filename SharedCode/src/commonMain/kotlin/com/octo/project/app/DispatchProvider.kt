package com.octo.project.app

import com.octo.project.multi.BackGroundDispatcher
import com.octo.project.multi.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher

open class DispatchProvider {
    open val main: CoroutineDispatcher by lazy { MainDispatcher }
    open val background: CoroutineDispatcher by lazy { BackGroundDispatcher }
}