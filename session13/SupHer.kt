data class Superhero(
    val name: String,
    val alias: String,
    val power: String,
    val favorite: Boolean = false,
    val accessibleDescription: String
)

fun formatHero(hero: Superhero): String {
    val favLabel = if (hero.favorite) " [Fav]" else ""
    return "${hero.name} (${hero.alias}) - ${hero.power}$favLabel (A11y: ${hero.accessibleDescription})"
}

fun filterByPower(heroes: List<Superhero>, powerQuery: String): List<Superhero> {
    val query = powerQuery.toLowerCase()
    return heroes.filter { it.power.toLowerCase().contains(query) }
}

fun getFavorites(heroes: List<Superhero>): List<Superhero> {
    return heroes.filter { it.favorite }
}

fun generateSchedule(heroes: List<Superhero>, days: Int): List<String> {
    val favorites = getFavorites(heroes)
    val source = if (favorites.isNotEmpty()) favorites else heroes

    val schedule = mutableListOf<String>()

    for (day in 1..days) {
        val hero = source[(day - 1) % source.size]
        schedule.add("Day $day: ${hero.name} (${hero.alias})")
    }

    return schedule
}

fun main() {

    val heroes = listOf(
        Superhero("Clark Kent","Superman","Flight",true,"Clark Kent, alias Superman, power Flight"),
        Superhero("Diana Prince","Wonder Woman","Strength",true,"Diana Prince, alias Wonder Woman, power Strength"),
        Superhero("Bruce Wayne","Batman","Intelligence",false,"Bruce Wayne, alias Batman, power Intelligence"),
        Superhero("Barry Allen","Flash","Speed",false,"Barry Allen, alias Flash, power Speed"),
        Superhero("Arthur Curry","Aquaman","Water Control",false,"Arthur Curry, alias Aquaman, power Water Control"),
        Superhero("Hal Jordan","Green Lantern","Energy Constructs",false,"Hal Jordan, alias Green Lantern, power Energy Constructs")
    )

    println("--- Superhero Directory ---")
    heroes.forEachIndexed { index, hero ->
        println("${index + 1}. ${formatHero(hero)}")
    }

    println("\n--- Filter: flight ---")
    val flightHeroes = filterByPower(heroes, "flight")
    flightHeroes.forEachIndexed { index, hero ->
        println("${index + 1}. ${formatHero(hero)}")
    }

    println("\n--- Favorites ---")
    val favorites = getFavorites(heroes)
    favorites.forEachIndexed { index, hero ->
        println("${index + 1}. ${formatHero(hero)}")
    }

    println("\n--- 30-Day Schedule ---")
    val schedule = generateSchedule(heroes, 30)
    schedule.forEach { println(it) }
}
