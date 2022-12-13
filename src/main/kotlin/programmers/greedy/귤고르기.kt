package programmers.greedy

class 귤고르기 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var result = 0
        var numOfType = 0
        tangerine.groupBy { it }.toList().sortedByDescending { it.second.size }.forEach {
            if(result >= k) {
                return numOfType
            }
            result += it.second.size
            numOfType++
        }
        return numOfType
    }
}
