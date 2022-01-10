package pages;

public class Parrot extends Animal {

    @Override
    public void speak() {
        System.out.println("Parrot has spoken!");
    }

    @Override
    public void walk() {
        System.out.println("Parrot " + name + " is flying!");
    }

}
