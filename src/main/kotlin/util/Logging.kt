package util

import java.time.LocalDateTime

fun <T> log(info: T) = println("[${LocalDateTime.now()} ${Thread.currentThread().name}]: $info" )