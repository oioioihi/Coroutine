plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    //코루틴 라이브러리
    // Kotlin은 언어수준에서 coroutine을 지원하지만 언어수준에서 지원하는 coroutine은 저수준 API뿐이기 때문에 실제 애플리케이션을 만들때 사용하는데 무리가 있다.
    // 따라서 고수준 API를 사용하기 위해서 jetbrains에서 제공한 coroutine 라이브러리를 추가한다.
 implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}