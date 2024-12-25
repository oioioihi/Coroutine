package section2

import kotlinx.coroutines.*

/**
 * 코루틴에 취소 확인 시점을 만드는 세가지 방법
 *
 * 1. delay 함수를 사용해 취소 확인 시점 만들기 -> 일시 중단 시점에 코루틴의 취소가 확인돼 취소된다.
 * 2. yield 함수를 사용해 취소 확인 시점 만들기 -> yield 함수를 호출한 코루틴은 자신이 사용하던 스레드를 양보한다.
 * delay 함수와 yield함수는 모두 일시중단 후 재개 과정을 거친다. -> 재개 시에는 CoroutineDispatcher에 의해 다시 스레드로 보내지는 과정을 거치기 때문에 비효율적이다.
 * 3. CoroutineScope.isActive를 사용한 취소 확인
 */


fun main() = runBlocking<Unit> {
    val whileJob = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
            yield()
            /**
             * 스레드를 양보한다는 것은 코루틴이 스레드 사용을 중단하고, 일시중단 한다는 뜻
             * 스레드를 양보한 후 곧바로 재개 요청을 한다.
             */
        }
    }

    delay(100L)
    whileJob.cancel()
}



