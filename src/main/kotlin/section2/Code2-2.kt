package section2

import kotlinx.coroutines.*

/**
 * Dispatchers.IO : 네트워크 요청이나 DB 읽기 쓰기 같은 입출력 (I/O)작업을 실행하느 디스패처
 * 사용할 수 있는 스레드의 수 : 64 와 JVM에서 사용할 수 있는 프로세서의 수 중 큰 값 -> Runtime.getRuntime().availableProcessors()
 *
 * Dispatchers.Default : CPU 바운드 작업을 위한 디스패처 -> 이미지, 동영상 처리 같은 끊이지 않고 연산이 필요한 작업
 * 사용할 수 있는 스레드이 수 : Runtime.getRuntime().availableProcessors()와 2중 큰 값 -> CPU 코어 수와 동일한 크기
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

    launch(Dispatchers.Default) {
        launch {
            println("[${Thread.currentThread().name}] 작업4 실행")
        }

        launch {
            println("[${Thread.currentThread().name}] 작업5 실행")
        }
        launch {
            println("[${Thread.currentThread().name}] 작업6 실행")
        }
    }
}