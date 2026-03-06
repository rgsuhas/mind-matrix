import kotlin.random.Random

fun rollDie(sides: Int, rnd: Random): Int {
    return rnd.nextInt(1, sides + 1)
}

fun rollTwoDice(rnd: Random): Pair<Int, Int> {
    val first = rollDie(6, rnd)
    val second = rollDie(6, rnd)
    return Pair(first, second)
}

fun formatRoll(rollNumber: Int, a: Int, b: Int): String {
    val base = "Roll $rollNumber: $a and $b"
    return if (a == b) "$base -> Double!" else base
}

fun main() {
    val rnd = Random(123)
    var rollNumber = 0

    println("--- Dice Roller ---")

    repeat(3) {
        println("Pressing 'Roll'...")
        rollNumber++

        val (a, b) = rollTwoDice(rnd)
        println(formatRoll(rollNumber, a, b))
    }
}