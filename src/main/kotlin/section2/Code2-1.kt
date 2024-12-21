package section2

import kotlinx.coroutines.*

/**
 * CoroutineDispatcher : 코루틴을 스레드로 보내는 주체
 * 개발자가 직접 아래와 같은 팩토리메서드를 통해 CoroutineDispatcher를 만들게 되면 Thread를 미리 생성해 메모리에 올려놓게 된다.
 * 물론 한번 만들고 재사용된다면 좋지만, 현업에서 그렇게 되지 못하기 때문에 Thread라는 비싼 자원이 낭비되어 애플리케이션이 무거워질 수 있다.
 */
val singleThreadDispatcher: CoroutineDispatcher=
    newSingleThreadContext("singleThread")
val multiThreadDispatcher : CoroutineDispatcher =
    newFixedThreadPoolContext(2,"multiThread")


fun main() = runBlocking<Unit> {
    println("Hello! 현재 '"+Thread.currentThread().name + "'가 실행")

    launch(singleThreadDispatcher) {
        println("Bye! 현재 '"+Thread.currentThread().name + "'가 실행")
    }

    launch(multiThreadDispatcher) {
        println("See you! 현재 '"+Thread.currentThread().name + "'가 실행")
    }

    launch(multiThreadDispatcher) {
        println("See you! 현재 '"+Thread.currentThread().name + "'가 실행")
    }
    launch(multiThreadDispatcher) {
        println("See you! 현재 '"+Thread.currentThread().name + "'가 실행")
    }
    launch(multiThreadDispatcher) {
        println("See you! 현재 '"+Thread.currentThread().name + "'가 실행")
    }
    launch(multiThreadDispatcher) {
        println("See you! 현재 '"+Thread.currentThread().name + "'가 실행")
    }

}