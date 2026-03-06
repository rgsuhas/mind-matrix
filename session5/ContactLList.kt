data class Contact(
    val name: String,
    val phone: String?,
    val email: String?,
    val isFavorite: Boolean                                                                                                                                        
)

fun addContact(list: MutableList<Contact>, contact: Contact) {
    list.add(contact)
}

fun filterContacts(
    contacts: List<Contact>,
    predicate: (Contact) -> Boolean
): List<Contact> {
    return contacts.filter(predicate)
}

fun displayContacts(contacts: List<Contact>) {
    if (contacts.isEmpty()) {
        println("No contacts found.")
        return
    }

    contacts.forEach {
        println("Name: ${it.name}")
        println("Phone: ${it.phone ?: "Not Available"}")
        println("Email: ${it.email ?: "Not Available"}")
        println("Favorite: ${if (it.isFavorite) "Yes" else "No"}")
        println("----------------------------")
    }
}

fun main() {
    val contactList = mutableListOf<Contact>()

    addContact(contactList, Contact("xxxx", "dffsdf", "dfssddf@email.com", true))
    addContact(contactList, Contact("xyyy", null, "dsfsdf@email.com", false))
    addContact(contactList, Contact("sdnsf", "sfsff", null, true))

    println("All Contacts:")
    displayContacts(contactList)

    println("Favorite Contacts:")
    val favorites = filterContacts(contactList) { it.isFavorite }
    displayContacts(favorites)

    println("Contacts with Email:")
    val emailContacts = filterContacts(contactList) { it.email != null }
    displayContacts(emailContacts)
}