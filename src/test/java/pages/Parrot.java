package pages;

public class Parrot extends Animal {

    public final static String PARROT_EMOJI = new String(Character.toChars( 0x1F99C));

    @Override
    public String toString() {
        return PARROT_EMOJI;
    }

    @Override
    public void speak() {
        System.out.println("Parrot has spoken!");
    }
}
