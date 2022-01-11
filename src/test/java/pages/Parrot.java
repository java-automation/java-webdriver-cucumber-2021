package pages;

public class Parrot extends Animal {
    public Parrot(String newName,
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

    public Parrot() {
        setName("nameless one");
    }

    @Override
    public void speak() {
        System.out.println("Parrot has spoken!");
    }
}
