package programmers.stack_queue

import java.util.*

data class Plan(val index: Int, val start: Int, var playTime: Int)

class `과제 진행 하기` {

    fun solution(plans: Array<Array<String>>): List<String> {
        val answer = mutableListOf<String>()

        val minutePlans = Array(plans.size) { i ->
            val time = plans[i][1].split(":")
            Plan(
                i,
                (time[0].toInt() * 60) + time[1].toInt(),
                plans[i][2].toInt()
            )
        }

        minutePlans.sortBy { it.start }

        val remain = Stack<Plan>()

        (0 until minutePlans.size - 1).forEach { i ->
            val cur = minutePlans[i].start + minutePlans[i].playTime
            val next = minutePlans[i + 1].start

            if (cur <= next) {
                answer.add(plans[minutePlans[i].index][0])

                var rest = next - cur
                while (rest > 0 && remain.isNotEmpty()) {
                    val del = remain.peek().playTime - rest
                    remain.peek().playTime = maxOf(0, del)
                    if (del <= 0) {
                        rest = -1 * del
                        answer.add(plans[remain.pop().index][0])
                    } else {
                        rest = 0
                    }
                }
            } else {
                minutePlans[i].playTime = (cur - next)
                remain.push(minutePlans[i])
            }
        }
        answer.add(plans[minutePlans[minutePlans.size - 1].index][0])

        while (remain.isNotEmpty()) {
            answer.add(plans[remain.pop().index][0])
        }

        return answer
    }
}
