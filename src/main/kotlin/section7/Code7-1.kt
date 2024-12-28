import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * 부모 코루틴은 자식 코루틴에게 실행 환경을 상속한다.
 * 부모 코루틴이 자식 코루틴을 생성하면 부모 코루틴의 CoroutineContext가 자식 코루틴에게 전달된다.
 *
 * 자식 코루틴을 생성하는 코루틴 빌더함수에 새로운 CoroutineContext 객체가 전달되면, 부모 코루틴에서 전달 받은 요소들은 덮어 씌워진다.
 */


fun main() = runBlocking<Unit> {
    val coroutineContext1 = newSingleThreadContext("MyThread") + CoroutineName("CoroutineA")
    launch(coroutineContext1) { //부모 코루틴 생성
        println("[${Thread.currentThread().name}] 부모 코루틴 실행")
        launch {// 자식 코루틴 생성
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
    }
}