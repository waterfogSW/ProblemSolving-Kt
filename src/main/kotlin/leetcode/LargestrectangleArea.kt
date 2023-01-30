package leetcode

import java.util.*

fun largestRectangleArea(heights: IntArray): Int {
    var max = 0
    val s = Stack<Pair<Int, Int>>()

    for ((i, h) in heights.withIndex()) {
        var left = i
        while (s.isNotEmpty() && s.peek().second > h) {
            val (index, height) = s.pop()
            max = maxOf(max, height * (i - index))
            left = index
        }
        s.add(left to h)
    }

    while (s.isNotEmpty()) {
        val (i, h) = s.pop()
        max = maxOf(max, h * (heights.size - i))
    }

    return max
}
