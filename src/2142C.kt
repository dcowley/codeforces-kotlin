fun main() {
    fun solve(input: String): String {
        val lowercase = mutableListOf<Pair<Char, Int>>()
        val uppercase = mutableListOf<Pair<Char, Int>>()

        input.forEachIndexed { index, c ->
            when {
                c == 'b' -> lowercase.removeLastOrNull()
                c == 'B' -> uppercase.removeLastOrNull()
                c.isUpperCase() -> uppercase.add(c to index)
                c.isLowerCase() -> lowercase.add(c to index)
            }
        }

        return (lowercase + uppercase)
            .sortedBy { it.second }
            .joinToString("") { "${it.first}" }
    }

    val t = readln().toInt()
    repeat(t) {
        println(solve(readln()))
    }
}
