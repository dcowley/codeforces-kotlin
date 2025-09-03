fun main() {
    fun solve(input: List<Int>, l: Int = input.size): Int {
        val indices = mutableMapOf<Int, MutableSet<Int>>()
        input.forEachIndexed { index, i ->
            indices.getOrPut(i, ::mutableSetOf) += index + 1

            if (indices.keys.count() == 2 && indices.any { it.value.size > 1 }) {
                return indices.values
                    .first { it.size == 1 }
                    .first()
            }
        }

        error("No solution!")
    }

    val t = readln().toInt()
    repeat(t) {
        val l = readln().toInt()
        val input = readln()
            .split(" ")
            .map(String::toInt)

        println(solve(input, l))
    }
}
