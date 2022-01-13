package pages;

public abstract class Animal implements Member {

    // fields
    private String name;
    private final String ANIMAL_EMOJI = new String(Character.toChars( 0x1F43E)); // paw prints
    private String group;

    // constructor
    public Animal() {
        setName("nameless one");
        setGroup(null);
    }

    // methods
    public Member setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry")) {
            name = newName;
        } else {
            throw new Error("Unacceptable name! " + newName);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return ANIMAL_EMOJI;
    }

    public Member setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public void walk() {
        System.out.println(getClass().getSimpleName() + " " + name + " is walking!");
    }

    public void sleep() {
        System.out.println(getClass().getSimpleName() + " " + name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println(getClass().getSimpleName() + " " + name + " is eating " + what + "!");
    }

    public abstract void speak();
}
