import kotlin.math.abs

private val example1 = """
        0 0 0 0 0
        0 0 0 0 1
        0 0 0 0 0
        0 0 0 0 0
        0 0 0 0 0
        """.trimIndent().lines()

private val example2 = """
        0 0 0 0 0
        0 0 0 0 0
        0 1 0 0 0
        0 0 0 0 0
        0 0 0 0 0
        """.trimIndent().lines()

fun main() {
    fun parse(input: List<String>) = input.map {
        it.split(" ")
            .map(String::toInt)
    }

    fun solve(input: List<List<Int>>): Int {
        val i = input.flatten().indexOf(1)
        val x = i % input.first().size + 1
        val y = i / input.size + 1
        return abs(3 - x) + abs(3 - y)
    }

    check(solve(parse(example1)) == 3)
    check(solve(parse(example2)) == 1)

    val inputLines = generateSequence(::readlnOrNull).toList()
    println(solve(parse(inputLines)))
}
