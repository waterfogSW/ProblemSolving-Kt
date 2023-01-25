package programmers.recursive

class `쿼드 압축후 개수세기` {
    class Solution {
        data class Pos(val x: Int, val y: Int)

        fun solution(arr: Array<IntArray>): IntArray {
            val result = intArrayOf(0, 0)

            fun isAllSame(depth: Int, pos: Pos): Boolean {
                for (i in 0 until depth) {
                    for (j in 0 until depth) {
                        if (arr[pos.x][pos.y] != arr[pos.x + i][pos.y + j]) {
                            return false
                        }
                    }
                }
                return true
            }

            fun recursive(depth: Int, pos: Pos) {
                val temp = arr[pos.x][pos.y]
                if (isAllSame(depth, pos)) {
                    result[temp]++
                    return
                }

                recursive(depth / 2, Pos(pos.x, pos.y))
                recursive(depth / 2, Pos(pos.x + depth / 2, pos.y))
                recursive(depth / 2, Pos(pos.x, pos.y + depth / 2))
                recursive(depth / 2, Pos(pos.x + depth / 2, pos.y + depth / 2))
            }

            recursive(arr.size, Pos(0, 0))
            return result
        }
    }
}
