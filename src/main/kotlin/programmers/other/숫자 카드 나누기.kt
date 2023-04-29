package programmers.other

import kotlin.math.max

class `숫자 카드 나누기` {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {

        return max(getMaxNumber(arrayA, arrayB), getMaxNumber(arrayB, arrayA))

    }

    private fun getMaxNumber(a: IntArray, b: IntArray): Int {
        a.sort()
        b.sort()

        val start = a.first()

        return (start downTo 1).firstOrNull {
            a.allElementCanDividedBy(it) && b.allElementCannotDividedBy(it)
        } ?: 0

    }

    private fun IntArray.allElementCanDividedBy(num: Int): Boolean {
        return this.none { it % num != 0 }
    }

    private fun IntArray.allElementCannotDividedBy(num: Int): Boolean {
        return this.none { it % num == 0 }
    }
}
