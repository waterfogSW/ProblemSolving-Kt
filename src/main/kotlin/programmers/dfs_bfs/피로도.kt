package programmers.dfs_bfs

import kotlin.math.max

class Solution {

    private var answer = 0
    private lateinit var visit: BooleanArray

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visit = BooleanArray(dungeons.size)
        dfs(k, 0, dungeons)
        return answer
    }

    private fun dfs(fatigue: Int, count: Int, dungeons: Array<IntArray>) {
        answer = max(answer, count)

        for ((i, dungeon) in dungeons.withIndex()) {
            if (visit[i] || fatigue < dungeon[0]) continue
            visit[i] = true
            dfs(fatigue - dungeon[1], count + 1, dungeons)
            visit[i] = false
        }
    }
}

class Solution2 {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val permutations = permutation((dungeons.indices).toList())
        var answer = 0

        for (permutation in permutations) {
            var fatigue = k
            var count = 0
            for (i in permutation) {
                if(fatigue < dungeons[i][0]) break
                fatigue -= dungeons[i][1]
                count++
            }
            answer = max(count, answer)
        }

        return answer
    }
}


fun <T> permutation(sub: List<T>, fin: List<T> = listOf()): List<List<T>> {
    return if (sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(sub - it, fin + it) }
}
