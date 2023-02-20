package leetcode

fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (target <= nums[mid]) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}
