package programmers.other

class `마법의 엘리베이터` {
    fun solution(storey: Int): Int {
        var answer = 0
        var temp = storey

        while (temp != 0) {
            var i = temp % 10
            temp /= 10

            if (i in 0..4) {
                answer += i
            } else if (i in 6..9) {
                answer += 10 - i
                temp += 1
            } else {
                if (temp % 10 in 0..4) {
                    answer += i
                } else {
                    answer += 10 - i
                    temp += 1
                }
            }
        }
        return answer
    }
}
