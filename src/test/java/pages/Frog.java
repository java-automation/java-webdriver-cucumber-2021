package pages;

public class Frog extends Animal {

    @Override
    public void walk() {
        System.out.println("Frog " + this.getName() + " is jumping!");
    }

    @Override
    public void sleep() {
        System.out.println("Frog " + this.getName() + " is hibernating!");
    }

    public void quack() {
        System.out.println("Frog " + this.getName() + " is quacking!");
    }
}
