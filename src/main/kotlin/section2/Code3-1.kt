package section2

import kotlinx.coroutines.*

/**
 * 코루틴에서 순차 처리가 필요한 이유
 * '토큰 업데이트 후 네트워크 요청', '이미지 변환 후 업로드 요청' 같이 작업 간에 종속성이 있는 경우 순차적으로 실행되어야 한다.
 */


fun main() {
    runBlocking<Unit> {

        val updateTokenJob = launch(Dispatchers.IO) { // 1. 메인스레드가 Dispatchers.IO에 updateTokenJob 코루틴 실행 요청
            println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
            delay(100L)
            println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
        }
        val networkCallJob = launch(Dispatchers.IO) { // 2. 메인스레드가 Dispatchers.IO에 networkCallJob 코루틴 실행 요청
            println("[${Thread.currentThread().name}] 네트워크 요청")
        }


    }
}