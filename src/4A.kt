fun main() {
    fun solve(input: String) = input.toInt().let {
        when {
            it > 2 && it % 2 == 0 -> "YES"
            else -> "NO"
        }
    }

    val input = requireNotNull(readlnOrNull())
    check(solve("8") == "YES")
    check(solve("2") == "NO")
    println(solve(input))
}
