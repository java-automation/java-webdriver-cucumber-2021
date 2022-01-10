package pages;

public class Cat extends Animal {

    public Cat(String newName) {
        name = newName;
    }

    @Override
    public void speak() {
        System.out.println("Cat " + getName() + " is meowing!");
    }

}
