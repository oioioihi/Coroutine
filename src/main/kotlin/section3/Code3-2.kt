package section3

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * CoroutineStart.LAZY
 *
 */


fun main() {
    runBlocking<Unit> {

        val startTime = System.currentTimeMillis()
        launch { //launch 함수를 호출해 실행하면, 코루틴이 즉시 실행된다.
            println("[${getElapsedTime(startTime)}] launch 코루틴 실행")
        }

        val lazyJob = launch(start = CoroutineStart.LAZY) { //launch 함수의 start인자로 CoroutineStart.LAZY를 넘기면 지연 코루틴이 생성된다.
            println("[${getElapsedTime(startTime)}] launch 코루틴 지연 실행")
        }

        lazyJob.start() // 코루틴 실행 -> join() 호출해도 실행됨(join은 실행한 스레드가 블럭됨)
        println("종료")
    }
}

fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime} 밀리초"
