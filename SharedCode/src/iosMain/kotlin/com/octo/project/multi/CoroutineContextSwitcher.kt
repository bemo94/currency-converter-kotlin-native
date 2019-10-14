package com.octo.project.multi

import kotlinx.coroutines.*
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual val mainContext: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

internal actual val backGroundContext: CoroutineDispatcher  = NsQueueDispatcher(dispatch_get_main_queue())

// NsQueueDispatcher(dispatch_get_global_queue(QOS_CLASS_USER_INTERACTIVE.toLong(), 0)) futur implementation?

internal class NsQueueDispatcher(private val dispatchQueue: dispatch_queue_t) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}

actual class CoroutineContextSwitcher private actual constructor(
    private val scope: CoroutineScope,
    private val mainContext: CoroutineContext,
    private val backgroundContext: CoroutineContext,
    private val job: Job
) : ThreadManager {

    actual companion object {
        actual fun newInstance(): CoroutineContextSwitcher {
            val job = Job()
            val mainContext = mainContext + job
            val backgroundContext = backGroundContext + job

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