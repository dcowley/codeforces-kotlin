fun main() {
    fun solve(input: Int): Int {
        val sequence = generateSequence(0) {
            var next = it + 1
            while (next % 3 == 0 || "$next".endsWith("3")) {
                next++
            }
            next
        }
        return sequence.elementAt(input)
    }

    val t = readln().toInt()
    repeat(t) {
        val k = readln().toInt()
        println(solve(k))
    }
}
