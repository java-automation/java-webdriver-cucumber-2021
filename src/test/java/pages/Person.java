package pages;

public class Person implements Member {

    private String name;
    private final String PERSON_EMOJI = new String(Character.toChars( 0x1F9D1)); // person
    private String group;

    public Person(String name) {
        this.name = name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return PERSON_EMOJI;
    }

    public Member setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getGroup() {
        return group;
    }
}
