package pages;

public class Frog extends Animal {

    @Override
    public void walk() {
        System.out.println("Frog '" + getName() + "' is jumping!");
    }

    @Override
    public void sleep() {
        System.out.println("Frog '" + getName() + "' is hibernating!");
    }

    public void speak() {
        System.out.println("Frog '" + getName() + "' is quacking!");
    }
}
