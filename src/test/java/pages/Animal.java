package pages;

public class Animal {
    private String name;

    public Animal() {
        setName("nameless");
    }

    public Animal(String newName) {
        setName(newName);
    }

    public void setName(String newName) {
        if (newName.isEmpty()) throw new Error("Empty animal name!");
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void walk() {
        System.out.println(name + " is walking!");
    }

    public void sleep() {
        System.out.println(name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println(name + " is eating " + what + "!");
    }
}
