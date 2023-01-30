package leetcode

class LFUCache(var capacity: Int) {
    private var vals: HashMap<Int, Int> = HashMap()
    private var counts: HashMap<Int, Int> = HashMap()
    private var lists: HashMap<Int, LinkedHashSet<Int>> = HashMap()
    private var min = -1

    init {
        lists[1] = LinkedHashSet()
    }

    fun get(key: Int): Int {
        if (!vals.containsKey(key)) return -1
        val count = counts[key]!!
        counts[key] = count + 1
        lists[count]!!.remove(key)
        if (count == min && lists[count]!!.size == 0) min++
        if (!lists.containsKey(count + 1)) lists[count + 1] = LinkedHashSet()
        lists[count + 1]!!.add(key)
        return vals[key]!!
    }

    fun set(key: Int, value: Int) {
        if (capacity <= 0) return
        if (vals.containsKey(key)) {
            vals[key] = value
            get(key)
            return
        }

        if (vals.size == capacity) {
            val evit = lists[min]!!.iterator().next()
            lists[min]!!.remove(evit)
            vals.remove(evit)
        }

        vals[key] = value
        counts[key] = 1
        min = 1
        lists[1]!!.add(key)
    }
}
