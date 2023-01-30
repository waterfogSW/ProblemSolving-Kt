package leetcode

fun tribonacci(n: Int): Int {
    if(n < 3) {
        when(n) {
            0 -> return 0
            1 -> return 1
            2 -> return 1
        }
    }

    val arr = IntArray(n + 1)
    arr[0] = 0
    arr[1] = 1
    arr[2] = 1

    for(i in 0..n - 3) {
        arr[i + 3] = arr[i] + arr[i + 1] + arr[i + 2]
    }
    return arr[n]
}
