package programmers.dfs_bfs

import java.util.*

class 단어변환 {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        val pq = PriorityQueue<Node> { n1, n2 -> n1.dist - n2.dist }
        val visit = words.associateWith { false }.toMutableMap()

        var answer = 0
        pq.add(Node(begin, 0))
        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (cur.word == target) {
                answer = cur.dist
                break
            }
            for (word in words) {
                if (diff(cur.word, word) != 1 || visit[word]!!) continue
                visit[word] = true
                pq.add(Node(word, cur.dist + 1))
            }
        }

        return answer
    }

    private fun diff(cur: String, next: String): Int {
        return cur.indices.count { next[it] != cur[it] }
    }

    private class Node(
        val word: String,
        val dist: Int,
    )
}
