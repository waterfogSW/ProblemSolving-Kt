package leetcode

fun distinctNames(ideas: Array<String>): Long {
    var result = 0L
    val map = mutableMapOf<Char, HashSet<String>>()
    for(i in ideas.groupBy { it[0] }) {
        map[i.key] = i.value.map { it.substring(1) }.toHashSet()
    }


    val keys = map.keys.toList()
    for (i in 0 until keys.size - 1) {
        for (j in i + 1 until keys.size) {
            val l1 = map[keys[i]]!!
            val l2 = map[keys[j]]!!
            val mutualCount = l1.count { l2.contains(it) }

            result += (l1.size - mutualCount) * (l2.size - mutualCount) * 2
        }
    }
    return result
}
