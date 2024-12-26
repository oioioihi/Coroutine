package section3

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴 취소 -> cancel 함수
 * cancel 함수는 코루틴을 곧바로 취소하지 않고, 취소 확인용 플래그를 '취소 요청됨'으로 바꾸는 역할만 한다.
 * 이후 미래에 취소 확인용 플래그가 확인되는 시점에 코루틴이 취소된다. -> 언제 코루틴이 취소될때 확실하게 알수 없음
 */


fun main() {
    runBlocking<Unit> {
        val startTime = System.currentTimeMillis()
        val longJob: Job = launch {
            repeat(10) { repeatTime ->
                delay(1000L)
                println("[${getElapsedTime(startTime)}] 반복횟수 ${repeatTime}")
            }
        }

        delay(2500L)
        longJob.cancel() // 코루틴 취소
    }
}



