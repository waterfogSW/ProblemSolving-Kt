package programmers.other

import java.util.*

class `올바른 괄호` {
    fun solution(p: String): String {
        return recursive(p)
    }

    private fun recursive(w: String): String {
        if (w.isEmpty()) {
            return w
        }

        val stack = Stack<Char>()
        var pivot = 0
        stack.add(w[0])

        for (i in 1..w.length) {
            if (stack.isEmpty()) {
                pivot = i
                break
            }
            when {
                stack.peek() == ')' && w[i] == '(' -> stack.pop()
                stack.peek() == '(' && w[i] == ')' -> stack.pop()
                else -> stack.add(w[i])
            }
        }

        val u = w.substring(0, pivot)
        val v = w.substring(pivot)

        return if (isCorrectString(u)) {
            u + recursive(v)
        } else {
            "(" + recursive(v) + ")" + u.substring(1, u.lastIndex)
                .replace(")", "t")
                .replace("(", ")")
                .replace("t", "(")
        }
    }

    private fun isCorrectString(s: String): Boolean {
        if (s[0] != '(') {
            return false
        }

        val stack = Stack<Char>()
        stack.add(s[0])

        var i = 1
        while (i < s.length) {
            if (stack.isNotEmpty() && stack.peek() == '(' && s[i] == ')') {
                stack.pop()
                i++
            } else {
                stack.add(s[i])
                i++
            }
        }
        return stack.isEmpty()
    }
}
