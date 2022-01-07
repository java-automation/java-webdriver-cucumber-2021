package pages;

public class Animal {
    //fields
    public String name;

    public void setName(String newName) {
        if ((!newName.isEmpty()) && (!newName.equals("Dusty"))) {
            name = newName;
        } else {
            throw new Error("Unacceptable name! " + newName);
        }
    }

    public String getName() {
        return name;
    }

    //constructor
    public Animal() {
        setName("nameless");
    }

    public Animal(String newName) {
        setName(newName);
    }

    //methods
    public void walk() {
        System.out.println("Animal " + name + " is walking!");
    }

    public void sleep() {
        System.out.println("Animal " + name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println("Animal " + name + " is eating " + what + "!");
    }

    public void speak() {
        System.out.println("Animal " + name + " is talking!");
    }

    public void swim() {
        System.out.println("Animal " + name + " is swimming!");
    }

    public void fly() {
        System.out.println("Animal " + name + " is flying!");
    }
}
