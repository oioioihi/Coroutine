package section2

import kotlinx.coroutines.*

/**
 * 코루틴 취소 -> cancel 함수
 * cancel 함수는 코루틴을 곧바로 취소하지 않고, 취소 확인용 플래그를 '취소 요청됨'으로 바꾸는 역할만 한다.
 * 이후 미래에 취소 확인용 플래그가 확인되는 시점에 코루틴이 취소된다. -> 언제 코루틴이 취소될때 확실하게 알수 없음
 */


fun main() {
    runBlocking<Unit> {

        val startTime = System.currentTimeMillis()
        val longJob: Job = launch(Dispatchers.Default) {
            Thread.sleep(1000L) // 코루틴의 일시 중단 되는 지점이 없기 때문에 결국엔 해당 로직을 모두 실행됨 -> delay(1000L)를 사용하면 일시중단 됨
            println("longJob 코루틴의 동작")
        }

//        longJob.cancel() // 코루틴 취소
        longJob.cancelAndJoin() // 취소 요청한 후 취소가 완료될 때까지 호출 코루틴 일시 중단
        executeAfterJobCancelled() // 코루틴 취소 후 실행되어야 하는 동작
    }
}

fun executeAfterJobCancelled() {
    println("longJob 코루틴 취소 후 실행되어야 하는 동작")
}

