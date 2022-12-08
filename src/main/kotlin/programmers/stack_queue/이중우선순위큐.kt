package programmers.stack_queue

import java.util.*

class 이중우선순위큐 {
    fun solution(operations: Array<String>): IntArray {
        val pq = DoublePriorityQueue()

        for (operation in operations) {
            val splits = operation.split(" ")
            when (splits[0]) {
                "I" -> pq.add(splits[1].toInt())
                "D" -> {
                    when (splits[1].toInt()) {
                        1 -> pq.removeBack()
                        -1 -> pq.removeFront()
                    }

                }
            }
        }

        return intArrayOf(pq.getLast(), pq.getFirst())
    }
}

class DoublePriorityQueue(
    private val list: LinkedList<Int> = LinkedList()
) {
    fun add(num: Int) {
        list.add(num)
        list.sort()
    }

    fun removeFront() {
        if(list.size == 0) {
            return
        }
        list.removeFirst()
    }

    fun removeBack() {
        if(list.size == 0) {
            return
        }
        list.removeLast()
    }

    fun getFirst(): Int {
        if(list.size == 0) {
            return 0
        }
        return list.first();
    }

    fun getLast(): Int {
        if(list.size == 0) {
            return 0
        }
        return list.last()
    }
}
