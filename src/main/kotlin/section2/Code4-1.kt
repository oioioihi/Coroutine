package section2

import kotlinx.coroutines.*

/**
 * 코루틴의 상태 (New, Active, Completed, Cancelling, Cancelled
 */


fun main() = runBlocking<Unit> {
    val job = launch {
        delay(1000L)
    }
    println(job) // 코루틴의 상태를 출력하기 위해서는 job 객체를 프린트 하면 된다.
    job.cancelAndJoin()
    println(job) // Cancelled


    val job2 = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
    }
    println(job2) // New
    job2.start()
    println(job2) // Active
    job2.join()
    println(job2) // Completed

}



