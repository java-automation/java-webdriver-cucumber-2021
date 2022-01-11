package pages;

public class Dog extends Animal {
    public Dog(String newName,
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

    public Dog() {
    }

    public void speak() {
        System.out.println("Dog " + name + " is barking");
    }

    @Override
    public void fly() {
        System.out.println(getClass() + " " + name + " doesn't fly!");
    }

}
