package com.octo.project.multi

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

internal actual val mainContext: CoroutineDispatcher = Dispatchers.Main
internal actual val backGroundContext: CoroutineDispatcher = Dispatchers.IO

actual class CoroutineContextSwitcher private actual constructor(
    private val scope: CoroutineScope,
    private val mainContext: CoroutineContext,
    private val backgroundContext: CoroutineContext,
    private val job: Job
) : ThreadManager {

    actual companion object {
        actual fun newInstance(): CoroutineContextSwitcher {
            val job = Job()
            val mainContext = Dispatchers.Main + job
            val backgroundContext = Dispatchers.IO + job

            return CoroutineContextSwitcher(
                scope = CoroutineScope(mainContext),
                mainContext = mainContext,
                backgroundContext = backgroundContext,
                job = job
            )
        }
    }

    override fun onMainThread(command: suspend CoroutineScope.() -> Unit) {
        scope.launch(mainContext) {
            command()
        }
    }

    override fun onBackgroundThread(command: suspend CoroutineScope.() -> Unit) {
        scope.launch(backgroundContext) {
            command()
        }
    }

    fun cancelJob() {
        job.cancel()
    }
}

actual fun<T> runBlockingTest(block: suspend () -> T): T {
    return runBlocking {
        block()
    }
}
