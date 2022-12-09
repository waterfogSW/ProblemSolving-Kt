package programmers.dp

class 멀리뛰기 {
    fun solution(n: Int): Long {
        val dp = LongArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        (2..n).forEach { i ->
            dp[i] = (dp[i] + dp[i - 1]) % DIV
            dp[i] = (dp[i] + dp[i - 2]) % DIV
        }

        return dp[n]
    }

    companion object {
        const val DIV = 1234567
    }
}
