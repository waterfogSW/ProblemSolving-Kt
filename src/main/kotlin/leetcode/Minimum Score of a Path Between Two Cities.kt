package leetcode // ktlint-disable filename

import java.util.*
import kotlin.math.min

data class Node(val dest: Int, val cost: Int)

fun minScore(n: Int, roads: Array<IntArray>): Int {
    val (a, b) = Pair(roads.size, roads[0].size)
    val graph = List<MutableList<Node>>(n + 1) { ArrayList() }

    for (road in roads) {
        graph[road[0]].add(Node(road[1], road[2]))
        graph[road[1]].add(Node(road[0], road[2]))
    }

    val q = LinkedList<Int>()
    val visit = BooleanArray(n + 1)
    q.add(1)
    var result = Int.MAX_VALUE

    while (q.isNotEmpty()) {
        val cur = q.poll()
        visit[cur] = true

        for (next in graph[cur]) {
            if (visit[next.dest]) continue
            result = min(result, next.cost)
            q.add(next.dest)
        }
    }

    return result
}
