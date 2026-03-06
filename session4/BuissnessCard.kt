/**
 * Business Card Console — Student Template
 *
 * Task:
 * Create a small console program that prints a "business card" using Kotlin functions.
 * Split the work into small functions (logo, header, contact block). Allow toggling whether contact info is shown.
 *
 * Instructions (step-by-step):
 * 1) Create a data class to hold name, title, phone and email.
 * 2) Write a function printLogo(width: Int) that prints a simple ASCII "logo" centered in the given width.
 * 3) Write a function printHeader(card: BusinessCard, width: Int) that prints the name and title centered.
 * 4) Write a function printContacts(card: BusinessCard, width: Int, showContacts: Boolean)
 *    that prints phone and email (only if showContacts is true).
 * 5) In main(), create an instance of BusinessCard and call the functions to display the full card.
 *
 * HINTS (do not implement here — hints only):
 * - Use a data class for the card: data class BusinessCard(val name: String, val title: String, val phone: String, val email: String)
 * - To center text: compute left padding = (width - text.length) / 2 and use " ".repeat(padding) + text
 * - Keep the card width consistent (e.g., 50 characters).
 * - Use functions to separate logic (logo, header, contacts).
 *
 * Sample Output (what the program should print) — exact text shown below in comments:
 *
 * --------------------------------------------------
 * |                    [ANDROID]                   |
 * |                                                |
 * |                 Aditya Deshpande               |
 * |                 Android Developer              |
 * |                                                |
 * |  Phone: +91-98765-43210                         |
 * |  Email: aditya@example.com                      |
 * --------------------------------------------------
 *
 * TODOs:
 * // TODO: Define BusinessCard data class
 * // TODO: Implement centerText(text: String, width: Int): String
 * // TODO: Implement printLogo(width: Int)
 * // TODO: Implement printHeader(card: BusinessCard, width: Int)
 * // TODO: Implement printContacts(card: BusinessCard, width: Int, showContacts: Boolean)
 * // TODO: Implement main() to build a BusinessCard and call the above functions
 */

 // -------------------------
 // Your code starts below
 // -------------------------

// TODO: Write your code here following the instructions above.
// Data class to hold business card information
data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String
)

// Function to center text within a given width
fun centerText(text: String, width: Int): String {
    val padding = (width - text.length) / 2
    return " ".repeat(if (padding > 0) padding else 0) + text
}

// Prints a simple ASCII logo
fun printLogo(width: Int) {
    val logo = "[ANDROID]"
    println("|" + centerText(logo, width - 2).padEnd(width - 2) + "|")
    println("|" + " ".repeat(width - 2) + "|")
}

// Prints name and title
fun printHeader(card: BusinessCard, width: Int) {
    println("|" + centerText(card.name, width - 2).padEnd(width - 2) + "|")
    println("|" + centerText(card.title, width - 2).padEnd(width - 2) + "|")
    println("|" + " ".repeat(width - 2) + "|")
}

// Prints contact details if enabled
fun printContacts(card: BusinessCard, width: Int, showContacts: Boolean) {
    if (showContacts) {
        val phoneText = "  Phone: ${card.phone}"
        val emailText = "  Email: ${card.email}"

        println("|" + phoneText.padEnd(width - 2) + "|")
        println("|" + emailText.padEnd(width - 2) + "|")
    }
}

// Main function
fun main() {
    val width = 50

    val card = BusinessCard(
        name = "Suhas R G",
        title = "Android Developer",
        phone = "+91-98765-43210",
        email = "suhas@example.com"
    )

    println("-".repeat(width))
    printLogo(width)
    printHeader(card, width)
    printContacts(card, width, true)
    println("-".repeat(width))
}