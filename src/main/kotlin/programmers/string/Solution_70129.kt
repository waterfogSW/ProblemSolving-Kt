package programmers.string

class Solution_70129 {
    fun solution(s: String): IntArray {
        var loopCount = 0
        var removedZero = 0
        var temp = s

        while (temp != "1") {
            removedZero += temp.replace("1", "").count()
            temp = Integer.toBinaryString(temp.replace("0", "").count())
            loopCount++
        }

        return intArrayOf(loopCount, removedZero)
    }
}
