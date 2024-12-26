package section5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * withContext
 * 인자로 받은 CoroutineDispatcher를 사용해 코루틴의 실행 스레드를 전환하고, 람다식의 코드를 실행한 후 결과값을 반환하는 함수
 * -> 람다식을 실행한 후에는 스레드가 다시 이전의 Dispatcher을 사용하도록 전환한다.
 */


fun main() = runBlocking {

    val result1 = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}] 결과값이 반환됩니다.")
        "결과 값"
    }
    println("[${Thread.currentThread().name} $result1]")

    val result2 = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}] 결과값이 반환됩니다.")
        "결과 값"
    }

    // withContext는 같은 코루틴이 유지된 상태에서 실행하는 스레드만 바뀌기 때문에 순차 처리된다.
    val results = listOf(result1, result2)
    println("합쳐진 결과값: ${results.joinToString(", ")}")

}
