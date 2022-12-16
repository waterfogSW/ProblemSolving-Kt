package programmers.dfs_bfs

import java.util.*

class 경주로건설 {

    private data class Node(val x: Int, val y: Int, val cost: Int, val dir: Int)

    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, -1, 0, 1)

    fun solution(board: Array<IntArray>): Int {
        var answer = 0

        val visit = Array(board.size) { Array(board.size) { 0 } }
        val pq = PriorityQueue<Node> { n1, n2 -> n1.cost - n2.cost }
        (0..3).forEach { pq.add(Node(0, 0, 0, it)) }
        visit[0][0] = 4

        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (cur.x == board.size - 1 && cur.y == board.size - 1) {
                answer = cur.cost
                break
            }

            for (i in 0..3) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx < 0 || ny < 0 || board.size <= nx || board.size <= ny) continue //범위밖 진행 불가
                if (board[nx][ny] == 1) continue //벽 방향 진행 불가
                if ((cur.dir + 2) % 4 == i) continue //반대 방향 진행 불가
                if (visit[nx][ny] > 4) continue

                val nextCost = (if (i == cur.dir) 100 else 600) + cur.cost
                pq.add(Node(nx, ny, nextCost, i))
                visit[nx][ny]++
            }
        }

        return answer
    }
}
