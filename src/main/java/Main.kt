package com.dlucci

import java.io.File


fun main(args: Array<String>) {

    val template = "%s %s"

    var last = -1
    var label = "(N/A - no previous measurement)"
    var increases = 0
    File("~/IdeaProjects/aoc-1/src/main/resources/data.txt").forEachLine {
        when {
            last == -1 -> {
                label = "(N/A - no previous measurement)"
            }
            last > it.toInt() -> {
                label = "(decreased)"
            }
            last < it.toInt() -> {
                label = "(increased)"
                increases++
            }
        }
        last = it.toInt()
        println(String.format(template, it, label))
    }

    println(increases)
}

