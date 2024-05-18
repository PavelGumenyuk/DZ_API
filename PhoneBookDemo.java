import java.util.*;

class Contact {
    private String name;
    private Set<String> phoneNumbers;

    public Contact(String name) {
        this.name = name;
        this.phoneNumbers = new HashSet<>();
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}

class PhoneBook {
    private Map<String, Contact> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = contacts.get(name);
        if (contact == null) {
            contact = new Contact(name);
            contacts.put(name, contact);
        }
        contact.addPhoneNumber(phoneNumber);
    }

    public void printSortedContacts() {
        // Сортировка по количеству телефонов
        Comparator<Map.Entry<String, Contact>> comparator =
                (entry1, entry2) -> Integer.compare(entry2.getValue().getPhoneNumbers().size(), entry1.getValue().getPhoneNumbers().size());

        // Печать отсортированного списка
        contacts.entrySet().stream()
                .sorted(comparator)
                .forEach(entry -> {
                    Contact contact = entry.getValue();
                    System.out.println(contact.getName() + ": " + contact.getPhoneNumbers());
                });
    }
}

public class PhoneBookDemo {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Иван", "+7 (903) 123-45-67");
        phoneBook.addContact("Мария", "+7 (905) 765-43-21");
        phoneBook.addContact("Иван", "+7 (926) 345-67-89");
        phoneBook.addContact("Сергей", "+7 (912) 987-65-43");
        phoneBook.addContact("Мария", "+7 (987) 654-32-10");

        phoneBook.printSortedContacts();
    }
}
