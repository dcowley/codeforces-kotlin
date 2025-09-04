fun main() {
    fun solve(input: String, l: Int = input.length): Int {
        val maxFrequency = input
            .groupBy { it }
            .maxOf { it.value.size }

        return when {
            maxFrequency > l / 2 -> 2 * maxFrequency - l
            else -> l % 2
        }
    }

    val t = readln().toInt()
    repeat(t) {
        val l = readln().toInt()
        println(solve(readln(), l))
    }
}
