package pages;

public class Cat extends Animal {
    // constructor
    public Cat(String newName) {
        setName(newName);
    }
    public Cat() {
        setName("nameless one");
    }

    public void speak() {
        System.out.println("Cat " + name + " is meowing!");
    }
}
