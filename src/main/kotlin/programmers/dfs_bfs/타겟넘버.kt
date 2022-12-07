package programmers.dfs_bfs

class 타겟넘버 {
    fun solution(numbers: IntArray, target: Int): Int {
        var count = 0
        fun dfs(depth: Int, value: Int) {
            if (depth == numbers.size) {
                if (value == target) {
                    count++
                }
                return
            }
            dfs(depth + 1, value + numbers[depth])
            dfs(depth + 1, value - numbers[depth])
        }

        dfs(0, 0)
        return count
    }
}
