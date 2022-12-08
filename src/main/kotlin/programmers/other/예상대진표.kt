package programmers.other

class 예상대진표 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var depth = 1
        var div = 2
        while (true) {
            if ((a - 1) / div == (b - 1) / div) {
                break
            }
            depth++
            div *= 2
        }

        return depth
    }
}
