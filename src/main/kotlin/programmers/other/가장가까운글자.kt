package programmers.other

class 가장가까운글자 {
    fun solution(s: String): IntArray {
        val map: MutableMap<Char, Int> = HashMap()
        val result = IntArray(s.length)
        for (i in s.indices) {
            if (!map.containsKey(s[i])) {
                map[s[i]] = -1
            }

            result[i] = if (map[s[i]]!! == -1) -1 else i - map[s[i]]!!
            map[s[i]] = i
        }


        return result
    }
}
