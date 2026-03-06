/**
 * Profile Card Console — Student Template
 *
 * Task (2-3 lines):
 * Build a console program that prints stylized "profile cards" for people.
 * Practice creating small reusable functions to render text blocks and optional ASCII image placeholders.
 *
 * Instructions (step-by-step):
 * 1) Create a data class `Profile(val name: String, val title: String, val bio: String)`
 * 2) Implement `renderAvatar(width: Int, height: Int): String`
 *    - Returns a multi-line string that represents an ASCII "image" placeholder of given width/height.
 *    - Example line: "[#####.....]" or a simple box with "Avatar" centered.
 * 3) Implement `renderTextBlock(label: String, text: String, width: Int): String`
 *    - Returns a string where `label` and `text` are shown, wrapped/padded to the given width.
 *    - Keep it simple: no need for full word-wrap; trim text if too long.
 * 4) Implement `renderProfile(profile: Profile, width: Int, showAvatar: Boolean): String`
 *    - Uses renderAvatar and renderTextBlock to build a card string.
 *    - If showAvatar is false, do not include the avatar.
 * 5) In `main()` create 3 sample profiles and print:
 *      - Profile with avatar shown
 *      - Profile without avatar
 *      - Another profile with avatar shown
 *
 * HINTS (comments only):
 * - Use String.repeat(n) to build lines and simple padding.
 * - To center text: compute left padding = (width - text.length) / 2.
 * - Keep functions pure: return strings; let main() print them.
 *
 * Sample Output (guideline; instructor solution below shows exact output):
 *
 * +----------------------+
 * | [Avatar 7x3]         |
 * |                      |
 * | Name: Ada Lovelace   |
 * | Title: Software Dev  |
 * | Bio: Early computing |
 * +----------------------+
 *
 * TODOs:
 * // TODO: Define data class Profile(...)
 * // TODO: Implement renderAvatar(width, height): String
 * // TODO: Implement renderTextBlock(label, text, width): String
 * // TODO: Implement renderProfile(profile, width, showAvatar): String
 * // TODO: Implement main() to create profiles and print them
 */
 
// -----------------
// Student area
// -----------------

// TODO: Define data class Profile(name: String, title: String, bio: String)
data class Profile(val name: String, val title: String, val bio: String)

// TODO: Implement fun renderAvatar(width: Int, height: Int): String
fun renderAvatar(width: Int, height: Int): String {
    val sb = StringBuilder()
    val text = "Avatar"
    for (i in 0 until height) {
        if (i == height / 2) {
            val padding = (width - text.length) / 2
            sb.append(" ".repeat(padding) + text + " ".repeat(width - padding - text.length))
        } else {
            sb.append("~".repeat(width))
        }
        sb.append("\n")
    }
    return sb.toString()
}

// TODO: Implement fun renderTextBlock(label: String, text: String, width: Int): String
fun renderTextBlock(label: String, text: String, width: Int): String {
    val content = "$label: $text"
    val trimmed = if (content.length > width) content.substring(0, width) else content
    return trimmed + " ".repeat(width - trimmed.length) + "\n"
}
// TODO: Implement fun renderProfile(profile: Profile, width: Int = 30, showAvatar: Boolean = true): String
fun renderProfile(profile: Profile, width: Int = 30, showAvatar: Boolean = true): String {
    val sb = StringBuilder()
    sb.append("+${"-".repeat(width)}+\n")
    if (showAvatar) {
        renderAvatar(width, 3).lines().forEach {
            if (it.isNotEmpty()) sb.append("|$it|\n")
        }
    }
    sb.append("|${renderTextBlock("Name", profile.name, width).trimEnd()}|\n")
    sb.append("|${renderTextBlock("Title", profile.title, width).trimEnd()}|\n")
    sb.append("|${renderTextBlock("Bio", profile.bio, width).trimEnd()}|\n")
    sb.append("+${"-".repeat(width)}+\n")
    return sb.toString()
}
// TODO: Implement main() to create sample profiles and print them


fun main() {
    val p1 = Profile("Ada Lovelace", "Software Dev", "Early computing pioneer")
    val p2 = Profile("Suhas R G", "Software Dev", "nobody")
    val p3 = Profile("Grace Hopper", "Computer Scientist", "COBOL pioneer")

    println(renderProfile(p1, 30, true))
    println(renderProfile(p2, 30, false))
    println(renderProfile(p3, 30, true))
}






















