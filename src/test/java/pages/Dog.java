package pages;

public class Dog extends Animal {

    private final String DOG_EMOJI = new String(Character.toChars( 0x1F436)); // dog face

    public Dog() {
        super();
    }

    public Dog(String newName) {
        this();
        setName(newName);
    }

    @Override
    public String toString() {
        return DOG_EMOJI;
    }

    @Override
    public void speak() {
        System.out.println("Dog " + getName() + " is barking");
    }

}