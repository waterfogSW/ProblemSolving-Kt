package leetcode

import java.util.*

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val graph = flights.groupBy { it[0] }
    val cheapest = IntArray(n) { Int.MAX_VALUE }

    val q = LinkedList<IntArray>()
    q.add(intArrayOf(src, 0, -1))

    while (q.isNotEmpty()) {
        val (loc, cost, stops) = q.poll()
        if (stops > k || cost >= cheapest[loc]) {
            continue
        }
        cheapest[loc] = cost
        val nextList = graph[loc] ?: continue
        for ((_, dest, price) in nextList) {
            q.add(intArrayOf(dest, cost + price, stops + 1))
        }
    }
    return if (cheapest[dst] == Int.MAX_VALUE) -1 else cheapest[dst]
}

//만약 도달 못할 가능성이 있는경우, 다익스트라는 모든 경우의수를 탐색하게 된다, 벨만포드와 다를 바 없음
