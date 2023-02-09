package leetcode

fun jump(nums: IntArray): Int {
    val dp = IntArray(nums.size) { Int.MAX_VALUE }
    dp[0] = 0
    for (i in nums.indices) {
        for (j in i + 1..i + nums[i]) {
            if (j >= nums.size || dp[i] + 1 > dp[j]) continue
            dp[j] = dp[i] + 1
        }
    }

    return dp.last()
}
