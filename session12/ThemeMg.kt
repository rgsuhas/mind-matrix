data class Theme(
    val name: String,
    val backgroundLabel: String,
    val textLabel: String
)

fun renderCard(title: String, subtitle: String, theme: Theme): String {
    return "[Theme: ${theme.name} | BG: ${theme.backgroundLabel} | Text: ${theme.textLabel}]\n" +
           "Card: $title (sub: $subtitle)"
}

fun animateProgress(totalSteps: Int, width: Int): List<String> {
    val frames = mutableListOf<String>()

    for (step in 0 until totalSteps) {
        val filled = ((step + 1) * width) / totalSteps
        val empty = width - filled

        val bar = "[" + "#".repeat(filled) + "-".repeat(empty) + "]"
        val percent = ((step + 1) * 100) / totalSteps

        frames.add("$bar $percent%")
    }

    return frames
}

fun applyThemeAndAnimate(
    title: String,
    subtitle: String,
    themes: List<Theme>,
    steps: Int,
    width: Int
) {
    for (theme in themes) {

        println("--- Applying: ${theme.name} ---")

        val card = renderCard(title, subtitle, theme)
        println(card)

        val frames = animateProgress(steps, width)
        frames.forEach { println(it) }
    }
}

fun main() {

    val light = Theme("Light", "SoftWhite", "DarkGray")
    val dark = Theme("Dark", "DeepBlack", "LightGray")

    applyThemeAndAnimate(
        "Welcome - Learn theming",
        "Simulate Material",
        listOf(light, dark),
        10,
        20
    )
}
