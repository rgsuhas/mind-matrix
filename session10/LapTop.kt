data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val stock: Int
)

fun applyDiscount(
    products: List<Product>,
    discountFunction: (Double) -> Double
): List<Product> {
    return products.map {
        Product(it.name, it.category, discountFunction(it.price), it.stock)
    }
}

fun filterProducts(
    products: List<Product>,
    condition: (Product) -> Boolean
): List<Product> {
    return products.filter(condition)
}

fun main() {

    val products = listOf(
        Product("Laptop", "Electronics", 100000.0, 5),
        Product("Phone", "Electronics", 50000.0, 15),
        Product("Chair", "Furniture", 2000.0, 25),
        Product("Table", "Furniture", 3000.0, 5),
        Product("Pen", "Stationery", 50.0, 100)
    )

    val discountedProducts = applyDiscount(products) { price ->
        price * 0.9
    }

    println("--- Discounted Product List ---")
    discountedProducts.forEach {
        println("Name: ${it.name} | Category: ${it.category} | Price: ${it.price} | Stock: ${it.stock}")
    }

    val lowStock = filterProducts(discountedProducts) { it.stock < 10 }

    println("\n--- Low Stock Products (<10) ---")
    lowStock.forEach {
        println("${it.name} (${it.stock})")
    }

    val premiumProducts = filterProducts(discountedProducts) { it.price > 1000 }

    println("\n--- Premium Products (>1000) ---")
    premiumProducts.forEach {
        println("${it.name} (${it.price})")
    }
}
