package leetcode

class SummaryRanges() {

    private val arr = mutableListOf<Int>()

    fun addNum(value: Int) {
        if(arr.contains(value)) return
        arr.add(value)
        arr.sort()
    }

    fun getIntervals(): Array<IntArray> {

        fun getIntervalFrom(start: Int): IntArray {
            var idx = start
            while (idx + 1 < arr.size && arr[idx] + 1 == arr[idx + 1]) {
                idx += 1
            }
            return intArrayOf(arr[start], arr[idx])
        }

        val result = mutableListOf<IntArray>()
        var idx = 0
        while (idx < arr.size) {
            val interval = getIntervalFrom(idx)
            result.add(interval)
            idx += interval[1] - interval[0] + 1
        }

        return result.toTypedArray()
    }

}
