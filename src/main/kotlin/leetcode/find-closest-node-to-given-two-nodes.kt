package leetcode.other

fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    fun search(start: Int): IntArray {
        val arr = IntArray(edges.size) { Int.MAX_VALUE }

        var cur = start
        arr[cur] = 0
        while (edges[cur] != -1) {
            val next = edges[cur]
            arr[next] = arr[cur] + 1
            cur = next
        }

        return arr
    }

    val arr1 = search(node1)
    val arr2 = search(node2)

    var result = 0
    var resultDist = Int.MAX_VALUE
    for (i in edges.indices) {
        if (arr1[i] == Int.MAX_VALUE || arr2[i] == Int.MAX_VALUE) continue

        val temp = Math.max(arr1[i], arr2[i])
        if (temp < resultDist) {
            result = i
            resultDist = temp
        }
    }
    return result
}
