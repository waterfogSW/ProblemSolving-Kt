package leetcode.other

import kotlin.math.min

class Solution {
    fun minFlipsMonoIncr(s: String): Int {
        var left = 0
        var right = s.count { it == '0' }
        var answer = right
        for (i in s.indices) {
            if(s[i] == '1') {
                left++
            } else {
                right--
            }
            answer = min(left + right, answer)
        }
        return answer
    }
}
