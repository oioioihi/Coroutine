import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


/**
 * 루틴에 의해 서브루틴이 호출되면 서브루틴의 실행이 완료될 때까지 다른 작업을 할 수 없는 것과 다르게
 * 코루틴은 함께(Co) 실행되는 루틴으로 서로 간에 스레드 사용을 양보하며 함께 실행된다.
 */

fun main() = runBlocking<Unit> {
    launch {
        while (true) {
            println("자식 코루틴에서 작업 실행 중")
            yield() // 스레드 사용 권한 양보
        }
    }
    while (true) {
        println("부모 코루틴에서 작업 실행 중")
        yield() // 스레드 사용 권한 양보
    }
}



