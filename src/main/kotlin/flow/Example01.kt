package flow

import util.log

fun m(i: Int): Int {
    log("m($i)")
    return i * i
}

fun f(i: Int): Boolean {
    log("f($i)")
    return i >= 10
}

fun main() {
    log("==== list ====")
    listOf(1,2,3,4,5,6,7,8,9,10)
        .map { m(it) }
        .filter { f(it) }
        .let { log(it) }

    log("==== sequence ====")
    sequenceOf(1,2,3,4,5,6,7,8,9,10)
        .map { m(it) }
        .filter { f(it) }
        .let { log(it) }
}