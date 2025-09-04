fun main() {
    fun solve(input: List<Int>, n: Int, l: Int, k: Int): Int {
        val memo = mutableMapOf<IntRange, Int>()

        val ip = input.indices.toList().binarySearch(fromIndex = l) { index ->
            fun search(index: Int): Int {
                val prev = memo[l until index]
                return when {
                    prev != null -> prev and input[index]

                    l < index -> search(index - 1) and input[index]

                    else -> input[index]
                }
            }

            val result = memo.getOrPut(l..index) { search(index) }
            when {
                result >= k -> -1
                else -> 1
            }
        }

        return if (memo.values.max() >= k) -ip - 1 else -1
    }

    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().split(" ").map(String::toInt)
        val q = readln().toInt()

        val output = IntArray(q) {
            val (l, k) = "(\\d+) (\\d+)".toRegex().find(readln())!!.destructured
            solve(a, n, l.toInt() - 1, k.toInt())
        }
        println(output.joinToString(" "))
    }
}
