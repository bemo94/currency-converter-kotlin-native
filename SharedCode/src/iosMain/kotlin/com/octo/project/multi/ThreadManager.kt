package com.octo.project.multi

import kotlinx.coroutines.*
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual val MainDispatcher: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

internal actual val BackGroundDispatcher: CoroutineDispatcher  = NsQueueDispatcher(dispatch_get_main_queue())
// NsQueueDispatcher(dispatch_get_global_queue(QOS_CLASS_USER_INTERACTIVE.toLong(), 0)) futur implementation?

internal class NsQueueDispatcher(private val dispatchQueue: dispatch_queue_t) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}

internal actual fun execute(func: suspend CoroutineScope.() -> Unit, dispatcher: CoroutineDispatcher) {
    GlobalScope.launch(dispatcher) {
        func()
    }
}


// à verifier les generics : lien?
actual fun<T> runBlockingTest(block: suspend () -> T): T {
    return runBlocking {
        block()
    }
}