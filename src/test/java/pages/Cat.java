package pages;

public class Cat extends Animal {

    public Cat(String name,
               Double weight,
               Double height,
               Double age,
               Boolean wings,
               Integer howManyLegs,
               Boolean isDomestic,
               Boolean isEndangered) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.wings = wings;
        this.howManyLegs = howManyLegs;
        this.isDomestic = isDomestic;
        this.isEndangered = isEndangered;
    }

    public Cat() {
        setName("nameless one");
    }

    public void speak() {
        System.out.println("Cat " + name + " is meowing");
    }

    @Override
    public void fly() {
        System.out.println(getClass() + " " + name + " DOESN'T fly!");
    }
}
