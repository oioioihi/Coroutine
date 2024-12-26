package section5

import kotlinx.coroutines.*
import section3.getElapsedTime

/**
 * await을 사용해 복수의 코루틴으로부터 결과값 수신하기
 */


fun main() = runBlocking {

    val startTime = System.currentTimeMillis() // 시작 시간 기록

    // 플랫폼1에서 등록한 관람객 목록을 가져오는 코루틴 실행
    val participantDeferred1 = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("철수", "영수")
    }

    // 플랫폼 2에서 등록한 관람객 목록을 가져오는 코루틴 실행
    val participantDeferred2 = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("영희")
    }

    // 결과가 수신 될 때까지 대기 -> 서로 간에 종속성이 없는 코루틴들에 대한 await의 호출은 모든 코루틴이 실행 요청된 후에 해야 한다.
    val participants1 = participantDeferred1.await()
    val participants2 = participantDeferred2.await()
    val results = awaitAll(participantDeferred1, participantDeferred2)

    // 지난 시간 표시 및 참여자 목록을 병합해 출력
    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*participants1, *participants2)}")
    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])}")
}
