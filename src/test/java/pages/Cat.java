package pages;

public class Cat {
    private String name;

    public Cat() {
        setName("nameless");
    }

    public Cat(String newName) {
        setName(newName);
    }

    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry")) {
            name = newName;
        } else {
            throw new Error("Unacceptable name! " + newName);
        }
    }

    public String getName() {
        return name;
    }

    public void walk() {
        System.out.println("Cat " + name + " is walking!");
    }

    public void sleep() {
        System.out.println("Cat " + name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println("Cat " + name + " is eating " + what + "!");
    }

    public void speak() {
        System.out.println("Cat " + name + " is meowing!");
    }
}
