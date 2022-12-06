package programmers.string

class JadenCase_문자열_만들기 {
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
