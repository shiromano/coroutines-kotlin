package flow

import util.log

fun square(i: Int): Int {
    log("m($i)")
    return i * i
}

fun main() {
    val s = listOf(1,2,3,4,5,6,7,8,9).map { square(it) }

    // s is only evaluated once
    log(s.find { it > 50 })
    log(s.find { it > 50 })

    log("----------")
    val l = sequenceOf(1,2,3,4,5,6,7,8,9).map { square(it) }

    // l will be evaluated each time it's used
    log(l.find { it > 50 })
    log(l.find { it > 50 })
}