package programmers.dfs_bfs

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
}
