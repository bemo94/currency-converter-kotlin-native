package com.octo.project.multi

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

internal expect val mainContext: CoroutineDispatcher
internal expect val backGroundContext: CoroutineDispatcher

interface ThreadManager {
    fun onMainThread(command: suspend CoroutineScope.() -> Unit)
    fun onBackgroundThread(command: suspend CoroutineScope.() -> Unit)
}

expect class CoroutineContextSwitcher private constructor(
    scope: CoroutineScope,
    mainContext: CoroutineContext,
    backgroundContext: CoroutineContext,
    job: Job
) : ThreadManager {
    companion object {
        fun newInstance(): CoroutineContextSwitcher
    }
}

expect fun <T> runBlockingTest(block: suspend () -> T): T