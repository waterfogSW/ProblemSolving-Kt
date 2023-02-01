package leetcode

fun gcdOfStrings(str1: String, str2: String): String {
    var answer = ""

    val (long, short) = if (str1.length > str2.length) Pair(str1, str2) else Pair(str2, str1)

    for (i in 1..short.length) {
        if (long.length % i != 0 && short.length % i != 0) continue

        val sub = short.substring(0, i)
        val longRepeat = long.length / i
        val shortRepeat = short.length / i

        if (sub.repeat(longRepeat) == long && sub.repeat(shortRepeat) == short) {
            answer = sub
        }
    }

    return answer
}
