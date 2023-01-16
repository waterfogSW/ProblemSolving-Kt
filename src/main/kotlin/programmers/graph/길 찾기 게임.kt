package programmers.graph

class Solution {

    private val preOrder = mutableListOf<Int>()
    private val postOrder = mutableListOf<Int>()

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val nodes = nodeinfo.withIndex()
                .map { (idx, value) -> Node(value[0], value[1], idx + 1) }
                .sortedWith(compareBy<Node> { -it.y }.thenBy { it.x })
                .toList()

        val root = nodes.first()
        nodes.subList(1, nodes.size)
                .forEach { connect(nodes.first(), it) }

        preOrdering(root)
        postOrdering(root)

        return arrayOf(preOrder.toIntArray(), postOrder.toIntArray())
    }

    private fun preOrdering(cur: Node?) {
        if (cur != null) {
            preOrder.add(cur.num)
            preOrdering(cur.left)
            preOrdering(cur.right)
        }
    }

    private fun postOrdering(cur: Node?) {
        if(cur != null) {
            postOrdering(cur.left)
            postOrdering(cur.right)
            postOrder.add(cur.num)
        }
    }

    private fun connect(parent: Node, child: Node) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child
            else connect(parent.left!!, child)
        } else {
            if (parent.right == null) parent.right = child
            else connect(parent.right!!, child)
        }
    }
}

data class Node(val x: Int, val y: Int, val num: Int) {
    var left: Node? = null
    var right: Node? = null
}
