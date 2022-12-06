package programmers.brutefoce

class 카펫 {
    fun solution(brown: Int, yellow: Int): IntArray {
        val area = brown + yellow
        val result = IntArray(2)
        for (m in area downTo 1) {
            if (area % m != 0) continue
            val n = area / m
            if (brown / 2 == m + n - 2) {
                result[0] = m
                result[1] = n
                break
            }
        }
        return result
    }
}
