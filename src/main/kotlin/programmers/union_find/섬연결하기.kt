package programmers.union_find

import java.util.*

class 섬연결하기 {

    fun solution(n: Int, costs: Array<IntArray>): Int {
        val pq = PriorityQueue<Bridge> { e1, e2 -> e1.cost - e2.cost }
        costs.mapTo(pq) { Bridge(it[0], it[1], it[2]) }

        val unionFind = UnionFind(n)
        var cost = 0
        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (unionFind.find(cur.start) != unionFind.find(cur.end)) {
                unionFind.union(cur.start, cur.end)
                cost += cur.cost
            }
        }

        return cost
    }

    class Bridge(val start: Int, val end: Int, val cost: Int)

    class UnionFind(n: Int) {
        private val root = IntArray(n) { i -> i }

        fun find(x: Int): Int {
            if (root[x] == x) return x
            root[x] = find(root[x])
            return root[x]
        }

        fun union(x: Int, y: Int) {
            val rx = find(x)
            val ry = find(y)
            root[rx] = ry
        }

    }

}
