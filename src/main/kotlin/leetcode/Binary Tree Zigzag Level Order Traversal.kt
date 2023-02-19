package leetcode

import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val map = mutableMapOf<Int, MutableList<Int>>()

        fun bfs(root: TreeNode) {
            val q = LinkedList<Node>()
            q.add(Node(0, root))

            while (q.isNotEmpty()) {
                val cur = q.poll()
                if (!map.containsKey(cur.depth)) {
                    map[cur.depth] = ArrayList<Int>()
                }

                map[cur.depth]!!.add(cur.node.`val`)

                if (cur.node.left != null) {
                    q.add(Node(cur.depth + 1, cur.node.left!!))
                }

                if (cur.node.right != null) {
                    q.add(Node(cur.depth + 1, cur.node.right!!))
                }
            }
        }

        bfs(root)
        val result = mutableListOf<List<Int>>()

        var a = 1
        for (key in map.keys) {
            result.add(if (a == 1) map[key]!! else map[key]!!.reversed())
            a *= -1
        }

        return result
    }

    data class Node(val depth: Int, val node: TreeNode)
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
