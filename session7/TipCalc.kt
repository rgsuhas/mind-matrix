import java.util.Locale
import kotlin.math.ceil

fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {
    var tip = amount * tipPercent / 100.0
    if (roundUp) {
        tip = ceil(tip)
    }
    return tip
}

fun formatAmount(amount: Double): String {
    return String.format(Locale.US, "%.2f", amount)
}

fun main() {
    val scenarios = listOf(
        Triple(50.00, 15, false),
        Triple(75.20, 18, true),
        Triple(100.00, 20, false)
    )

    scenarios.forEach { (amount, percent, roundUp) ->
        val tip = calculateTip(amount, percent, roundUp)
        println(
            "Bill: ${formatAmount(amount)} | Tip percent: ${percent}% | Round up: $roundUp | Tip: ${formatAmount(tip)}"
        )
    }
}