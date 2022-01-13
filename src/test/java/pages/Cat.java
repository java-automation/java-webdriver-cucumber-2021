package pages;

public class Cat extends Animal {

    private final String CAT_EMOJI = new String(Character.toChars( 0x1F431)); // cat face

    public Cat() {
        super();
    }

    public Cat(String newName) {
        this();
        setName(newName);
    }

    @Override
    public String toString() {
        return CAT_EMOJI;
    }

    @Override
    public void speak() {
        System.out.println("Cat " + getName() + " is meowing!");
    }

}
