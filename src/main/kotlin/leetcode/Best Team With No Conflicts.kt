package leetcode


data class Player(val score: Int, val age: Int)

fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
    val players = scores.indices.map { Player(scores[it], ages[it]) }
            .sortedBy { it.score }
            .sortedBy { it.age }

    val dp = IntArray(players.size)

    fun dfs(start: Int, sum: Int) {
        if (sum < dp[start]) return
        dp[start] = sum
        for (i in start + 1..scores.lastIndex) {
            if (players[start].age < players[i].age && players[i].score < players[start].score) continue
            dfs(i, sum + players[i].score)
        }
    }
    players.indices.forEach { dfs(it, players[it].score) }

    return dp.sorted().last()
}
