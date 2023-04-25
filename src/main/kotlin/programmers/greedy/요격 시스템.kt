package programmers.greedy

class `요격 시스템` {
    fun solution(targets: Array<IntArray>): Int {
        // 각 폭격 미사일의 끝나는 지점을 기준으로 정렬한다.
        val sortedTargets = targets.sortedBy { it[1] }
        // 필요한 요격 미사일 수를 저장할 변수를 초기화한다.
        var numMissiles = 0
        // 현재까지 요격한 폭격 미사일의 가장 마지막 위치를 저장할 변수를 초기화한다.
        var lastMissile = -1
        // 각 폭격 미사일에 대해 반복한다.
        for (target in sortedTargets) {
            // 현재 폭격 미사일이 이미 요격된 범위에 속하는 경우, 넘어간다.
            if (target[0] < lastMissile) {
                continue
            }
            // 현재 폭격 미사일을 요격하기 위한 요격 미사일을 발사한다.
            numMissiles++
            // 발사한 요격 미사일이 요격할 수 있는 폭격 미사일의 범위를 저장한다.
            lastMissile = target[1]
        }
        // 필요한 요격 미사일 수를 반환한다.
        return numMissiles
    }
}
