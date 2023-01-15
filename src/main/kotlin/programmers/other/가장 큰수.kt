package programmers.other

class Solution {
    fun solution(numbers: IntArray): String {
        return numbers
            .sortedWith { n1, n2 -> "$n2$n1".compareTo("$n1$n2") }
            .joinToString("")
            .run{ if(this[0] == '0') "0" else this }
    }
}
