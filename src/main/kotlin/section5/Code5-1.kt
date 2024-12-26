package section5

import kotlinx.coroutines.*

/**
 * async 코루틴 빌더를 호출하면 코루틴이 생성되고, Deferred<T> 타입의 객체가 반환된다.
 * Deferred는 Job과 같이 코루틴을 추상화한 객체이지만, 코루틴으로부터 생성된 결과값을 감싸는 기능을 추가로 가진다.
 * 결과값의 타입은 제네릭 타입인 T로 표현된다.
 * async 함수가 launch 함수오 다른 점은 block 람다식이 T를 반환한다는 점과 반환 객체가 Deferred<T>라는 점이다.
 */


fun main() = runBlocking {

    /**
     * Deferred 객체는 미래의 어느 시점에 결과값이 반환될 수 있음을 표현하는 코루틴 객체이다.
     * 코루틴이 실행 완료되었을 때 결과값이 반환되므로 언제 수신될 지 알 수 없다.
     * 따라서 만약 결과값이 필요하다면 결과값이 수신될 때까지 대기해야 한다.
     */
    val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
        delay(1000L) // 네트워크 요청
        return@async "Dummy Response" // Dummy Response 반환
    }

    val result = networkDeferred.await() // networkDeferred로부터 결과값이 반환될 때까지 runBlocking 일시 중단됨
    println(result)
}