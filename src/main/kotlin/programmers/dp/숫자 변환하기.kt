package programmers.dp

class `숫자 변환하기` {
    class Solution {
        fun solution(x: Int, y: Int, n: Int): Int {
            val count = IntArray(y + 1)
            val max = 1_000_001
            count[x] = 0
            for (i in x + 1..y) {
                val a = if (i / 2 >= x && i % 2 == 0) count[i / 2] else max
                val b = if (i / 3 >= x && i % 3 == 0) count[i / 3] else max
                val c = if (i - n >= x) count[i - n] else max

                count[i] = intArrayOf(a,b,c).minOrNull()!! + 1
            }
            return if (count[y] == max + 1) -1 else count[y]
        }
    }
}
