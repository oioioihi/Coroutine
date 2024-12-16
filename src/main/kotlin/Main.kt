package org.example

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() =runBlocking<Unit>(CoroutineName("runBlocking Coroutine")) { // runBlocking -> 코루틴이 종료될 때 스레드 점유가 해제된다.
    val name = "Kotlin"
    val currentThread = Thread.currentThread().name
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "! / Thread is -> " + currentThread)

    launch (CoroutineName("launch Coroutine")) { // 코루틴을 추가로 생성할 수 있다.
        for (i in 1..5) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            println("i = $i / Thread is -> " + Thread.currentThread().name)
        }

        println("Bye, " + name + "! / Thread is -> " + currentThread)

    }

}