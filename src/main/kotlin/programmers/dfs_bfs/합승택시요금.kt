package programmers.dfs_bfs

import java.util.*
import kotlin.math.min

class 합승택시요금 {

    data class Node(val dest: Int, val cost: Int)

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val graph = ArrayList<ArrayList<Node>>(n + 1)
        (0..n).forEach { _ -> graph.add(ArrayList()) }
        fares.forEach {
            graph[it[0]].add(Node(it[1], it[2]))
            graph[it[1]].add(Node(it[0], it[2]))
        }

        fun minCost(from: Int, to: Int): Int {
            val pq = PriorityQueue<Node> { n1, n2 -> n1.cost - n2.cost }
            val dist = IntArray(n + 1) { Int.MAX_VALUE }
            pq.add(Node(from, 0))

            while (!pq.isEmpty()) {
                val cur = pq.poll()
                if (cur.dest == to) {
                    return cur.cost
                }

                for (next in graph[cur.dest]) {
                    if(dist[next.dest] < next.cost + cur.cost) continue
                    dist[next.dest] = next.cost + cur.cost
                    pq.add(Node(next.dest, next.cost + cur.cost))
                }
            }
            return 200 * 100000
        }

        var answer = Int.MAX_VALUE
        for (i in (1..n)) {
            val dist1 = minCost(i, a)
            val dist2 = minCost(i, b)
            val dist3 = minCost(i, s)
            answer = min(answer, dist1 + dist2 + dist3)
        }

        return answer
    }
}
