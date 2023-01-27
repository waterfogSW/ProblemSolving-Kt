package leetcode

class `Concatenated Words` {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val wordSet = words.toHashSet()

        fun isConcatenated(word: String, isSubString: Boolean): Boolean {
            if (isSubString && word in wordSet) {
                return true
            }

            var result = false
            for (i in 1 until word.length) {
                if (word.substring(0, i) in wordSet) {
                    result = result || isConcatenated(word.substring(i), true)
                }
            }
            return result
        }

        return words.filter { isConcatenated(it, false) }.toList()
    }
}
