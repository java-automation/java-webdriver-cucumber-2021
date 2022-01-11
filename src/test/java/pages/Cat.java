package pages;

public class Cat extends Animal {

    public Cat(String newName) {
        name = newName;
    }

    public Cat() {
    }

    public void speak() {
        System.out.println("Cat " + name + " is meowing");
    }

}
