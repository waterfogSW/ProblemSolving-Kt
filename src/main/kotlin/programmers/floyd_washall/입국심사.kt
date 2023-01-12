package programmers.floyd_washall

fun solution(n: Int, results: Array<IntArray>): Int {
    val graph = Array(n + 1) { IntArray(n + 1) }
    results.forEach {
        graph[it[0]][it[1]] = 1
        graph[it[1]][it[0]] = -1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (graph[k][i] * graph[k][j] == -1) {
                    graph[i][j] = graph[k][j]
                    graph[j][i] = graph[k][i]
                }
            }
        }
    }

    return graph.count { it.count { it == 0 } == 2 }
}
