data class Item(
    val name: String,
    val category: String,
    val quantity: Int
)

fun printInventory(items: List<Item>) {
    if (items.isEmpty()) {
        println("No items found.")
        return
    }

    items.forEach {
        println("Name: ${it.name} | Category: ${it.category} | Qty: ${it.quantity}")
    }
}

fun <T> filterList(list: List<T>, condition: (T) -> Boolean): List<T> {
    return list.filter(condition)
}

fun main() {

    val inventory = listOf(
        Item("Laptop", "Electronics", 12),
        Item("Keyboard", "Electronics", 5),
        Item("Chair", "Furniture", 20),
        Item("Table", "Furniture", 8),
        Item("Notebook", "Stationery", 50)
    )

    println("--- Full Inventory ---")
    printInventory(inventory)

    println("\n--- Low Stock (<10) ---")
    val lowStock = filterList(inventory) { it.quantity < 10 }
    printInventory(lowStock)

    println("\n--- Electronics Category ---")
    val electronics = filterList(inventory) { it.category == "Electronics" }
    printInventory(electronics)

    println("\n--- Total Quantity per Category ---")

    val grouped = inventory.groupBy { it.category }

    val totals = grouped.mapValues { entry ->
        entry.value.map { it.quantity }.sum()
    }

    totals.forEach { entry ->
        println("${entry.key}: ${entry.value}")
    }
}
