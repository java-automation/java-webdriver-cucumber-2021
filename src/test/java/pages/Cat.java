package pages;

public class Cat extends Animal {  // to connect to Animal class

    public Cat(String newName) {
        setName(newName);
    }

    public Cat() {

    }

    public void speak() {
        System.out.println("Cat " + name + " is meowing") ;
    }
}
