package section6

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * CoroutineContext
 * 코루틴의 실행 환경을 관리하는 요소 -> 어디에서 실행되고, 어떤속성을 가지며, 어떤 작업을 수행할지를 결정하는 속성
 * CoroutineContext 객체에 같은 구성요소가 둘 이상 더해지면, 나중에 추가된 구성요소가 이전 값을 덮어씌운다.
 */
fun main() = runBlocking<Unit> {

    val coroutineContext =
        newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    val coroutineContext1 = newSingleThreadContext("NewThread") + CoroutineName("NewCoroutine")
    val coroutineContext2 = coroutineContext + coroutineContext1
    launch(context = coroutineContext) {
        println("[${Thread.currentThread().name}] 실행")
    }

    launch(context = coroutineContext2) {
        println("[${Thread.currentThread().name}] 실행")
    }
}