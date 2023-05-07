package programmers.dfs_bfs

import java.util.*

class 네트워크 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var result = 0
        val visit = BooleanArray(n)

        fun dfs(cur: Int) {
            for (next in 0 until n) {
                if (computers[cur][next] == 0 || visit[next]) continue
                visit[next] = true
                dfs(next)
            }
        }

        for (cur in 0 until n) {
            if (visit[cur]) continue
            visit[cur] = true
            result++
            dfs(cur)
        }

        return result
    }

    fun bfs_solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        val visit = BooleanArray(n)

        fun bfs(start: Int) {
            val q = LinkedList<Int>()
            q.add(start)
            visit[start] = true
            while (q.isNotEmpty()) {
                val cur = q.poll()
                for (next in 0 until n) {
                    if (next != cur && !visit[next] && computers[cur][next] == 1) {
                        visit[next] = true
                        q.add(next)
                    }
                }
            }
        }

        for(i in 0 until n) {
            if(!visit[i]) {
                answer++
                bfs(i)
            }
        }

        return answer
    }
}
