package section2

import kotlinx.coroutines.*

/**
 */


fun main() {
    runBlocking<Unit> {

        val startTime = System.currentTimeMillis()
        val longJob: Job = launch(Dispatchers.Default) {
            Thread.sleep(1000L) // 코루틴의 일시 중단 되는 지점이 없기 때문에 결국엔 해당 로직을 모두 실행됨 -> delay(1000L)를 사용하면 일시중단 됨
            println("longJob 코루틴의 동작")
        }

        longJob.cancelAndJoin() // 취소 요청한 후 취소가 완료될 때까지 호출 코루틴 일시 중단
    }
}


