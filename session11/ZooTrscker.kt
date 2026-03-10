abstract class Animal(val name: String) {
    abstract fun makeSound()
}

interface Feedable {
    fun feed(food: String)
}

class Lion(name: String) : Animal(name), Feedable {

    override fun makeSound() {
        println("$name: Roar!")
    }

    fun hunt() {
        println("$name is hunting.")
    }

    override fun feed(food: String) {
        println("$name eats $food.")
    }
}

class Elephant(name: String) : Animal(name), Feedable {

    override fun makeSound() {
        println("$name: Trumpet!")
    }

    fun sprayWater() {
        println("$name sprays water from trunk.")
    }

    override fun feed(food: String) {
        println("$name eats $food.")
    }
}

class Parrot(name: String) : Animal(name) {

    override fun makeSound() {
        println("$name: Chirp!")
    }

    fun mimic() {
        println("$name mimics human speech.")
    }
}

fun displayZoo(animals: List<Animal>) {
    println("--- Zoo Tracker ---")
    animals.forEach {
        it.makeSound()
    }
}

fun main() {

    val lion = Lion("Lion")
    val elephant = Elephant("Elephant")
    val parrot = Parrot("Parrot")

    val animals: List<Animal> = listOf(lion, elephant, parrot)

    displayZoo(animals)

    lion.feed("meat")
    elephant.feed("grass")

    elephant.sprayWater()
}
