package pages;

public interface Member {

    // family (people and pets), visitors (people and animals), study subjects, book characters, famous figures
    Member setGroup(String group);
    String getGroup();
    Member setName(String name);
    String getName();
    String toString();

}

