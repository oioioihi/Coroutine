package section3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

        // join함수를 사용하면 join 함수의 대상이 된 코루틴이 완료될 때까지 join 함수를 호출한 코루틴이 일시 중단된다.
        updateTokenJob.join() // 2.networkCallJob 실행 전 updateTokenJob 완료 될때 까지 기다림 -> joinAll(updateTokenJob)


        val networkCallJob = launch(Dispatchers.IO) { // 3. 메인스레드가 Dispatchers.IO에 networkCallJob 코루틴 실행 요청
            println("[${Thread.currentThread().name}] 네트워크 요청")
        }


    }
}