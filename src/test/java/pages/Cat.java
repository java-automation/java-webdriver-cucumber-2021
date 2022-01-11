package pages;

public class Cat extends Animal {

    public Cat(String newName,
               Double newWeight,
               Double newHeight,
               Double newAge,
               Boolean newWings,
               Integer newHowManyLegs,
               Boolean newIsDomestic,
               Boolean newIsEndangered) {
        name = newName;
        weight = newWeight;
        height = newHeight;
        age = newAge;
        wings = newWings;
        howManyLegs = newHowManyLegs;
        isDomestic = newIsDomestic;
        isEndangered = newIsEndangered;
    }

    public Cat() {
    }

    public void speak() {
        System.out.println("Cat " + name + " is meowing");
    }

    @Override
    public void fly() {
        System.out.println(getClass() + " " + name + " DOESN'T fly!");
    }
}
