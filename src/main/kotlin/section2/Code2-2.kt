package section2

import kotlinx.coroutines.*

/**
 * Dispatchers.IO : 네트워크 요청이나 DB 읽기 쓰기 같은 입출력 (I/O)작업을 실행하느 디스패처
 * 사용할 수 있는 스레드의 수 : 64 와 JVM에서 사용할 수 있는 프로세서의 수 중 큰 값 -> Runtime.getRuntime().availableProcessors()
 */


fun main() = runBlocking<Unit> {

    launch(Dispatchers.IO) { // 부모 코루틴

        launch { // 부모 코루틴의 디스패처(Dispathcers.IO)를 사용해 실행되는 코루틴들
            println("[${Thread.currentThread().name}] 작업1 실행")
        }

        launch {
            println("[${Thread.currentThread().name}] 작업2 실행")
        }

        launch {
            println("[${Thread.currentThread().name}] 작업3 실행")
        }
    }
}