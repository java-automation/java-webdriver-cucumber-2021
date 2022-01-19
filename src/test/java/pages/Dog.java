package pages;

import net.bytebuddy.implementation.bytecode.Throw;

public class Dog extends Animal {

    //constructor
    public Dog(String newName) {
        setName(newName);
    }
    public Dog() {
        name = "nameless";
        setName("nameless");
    }

    public void speak() {
        System.out.println("Dog " + name + " is barking");
    }


}
