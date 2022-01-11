package pages;

public class Animal {

    // fields
    protected String name;
    public Double weight;
    public Double height;
    public Double age;
    public Boolean wings;
    public Integer howManyLegs;
    public Boolean isDomestic;
    public Boolean isEndangered;


    // constructor
    public Animal(String name,
                  Double weight,
                  Double height,
                  Double age,
                  Boolean wings,
                  Integer howManyLegs,
                  Boolean isDomestic,
                  Boolean isEndangered
    ) {
        setName("nameless one");
    }

    public Animal() {
        setName("nameless one");
    }

    // methods
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
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Boolean getWings() {
        return wings;
    }

    public void setWings(Boolean wings) {
        this.wings = wings;
    }

    public Integer getHowManyLegs() {
        return howManyLegs;
    }

    public void setHowManyLegs(Integer howManyLegs) {
        this.howManyLegs = howManyLegs;
    }

    public Boolean getDomestic() {
        return isDomestic;
    }

    public void setDomestic(Boolean domestic) {
        isDomestic = domestic;
    }

    public Boolean getEndangered() {
        return isEndangered;
    }

    public void setEndangered(Boolean endangered) {
        isEndangered = endangered;
    }

    public void walk() {
        System.out.println(getClass() + " " + name + " is walking!");
    }

    public void sleep() {
        System.out.println(getClass() + " " + name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println(getClass() + " " + name + " is eating " + what + "!");
    }

    public void speak() {
    }

    public void fly() {
        System.out.println(getClass() + " " + name + " is flying!");
    }
}
