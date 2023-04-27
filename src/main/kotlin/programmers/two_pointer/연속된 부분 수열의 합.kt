package programmers.two_pointer

class `연속된 부분 수열의 합` {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf(0, sequence.size - 1)

        var start = 0
        var end = 0
        var sum = sequence[0]

        while (start < sequence.size) {

            if (end == sequence.size - 1) {
                sum -= sequence[start]
                start++
                if (sum == k && end - start < answer[1] - answer[0]) {
                    answer[0] = start
                    answer[1] = end
                }
                continue
            }

            if (sum == k) {
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start
                    answer[1] = end
                }
                end++
                sum += sequence[end]
            } else if (sum < k) {
                end++
                sum += sequence[end]
            } else {
                sum -= sequence[start]
                start++
            }
        }

        return answer
    }
}
