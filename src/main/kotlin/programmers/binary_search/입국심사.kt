package programmers.binary_search

class 입국심사 {
    fun solution(n: Int, times: IntArray): Long {
        var left = 1L
        var right = times.maxOrNull()!!.toLong() * n

        while (left < right) {
            val mid = (left + right) / 2
            val count = times.sumOf { mid / it }
            if (count >= n) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
}
