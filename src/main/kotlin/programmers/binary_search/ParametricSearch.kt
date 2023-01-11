package programmers.binary_search

fun lowerBound(n: Int, arr: IntArray): Int {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val mid = (left + right) / 2
        if (n <= arr[mid]) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

fun upperBound(n: Int, arr: IntArray): Int {
    var left = 0
    var right = arr.size - 1

    while(left < right) {
        val mid = (left + right) / 2
        if(arr[mid] <= n) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

fun main() {
    val sample = intArrayOf(1,2,2,3,3,3,4,5,6)
    val result = lowerBound(3, sample) // 3이상 첫 인덱스
    val result2 = upperBound(3, sample) // 3보다 큰 첫 인덱스
    println(result)
    println(result2)

}
