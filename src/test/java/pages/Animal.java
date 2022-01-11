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
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.wings = wings;
        this.howManyLegs = howManyLegs;
        this.isDomestic = isDomestic;
        this.isEndangered = isEndangered;
    }

    public Animal() {
        setName("nameless one");
    }

    // methods
    public Animal setName(String name) {
        if (!name.isEmpty() && !name.equals("Jerry")) {
            this.name = name;
        } else {
            throw new Error("Unacceptable name! " + name);
        }
        return this;
    }

    public String getName() {
       return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Animal setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public Animal setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getAge() {
        return age;
    }

    public Animal setAge(Double age) {
        this.age = age;
        return this;
    }

    public Boolean getWings() {
        return wings;
    }

    public Animal setWings(Boolean wings) {
        this.wings = wings;
        return this;
    }

    public Integer getHowManyLegs() {
        return howManyLegs;
    }

    public Animal setHowManyLegs(Integer howManyLegs) {
        this.howManyLegs = howManyLegs;
        return this;
    }

    public Boolean getDomestic() {
        return isDomestic;
    }

    public Animal setDomestic(Boolean domestic) {
        isDomestic = domestic;
        return this;
    }

    public Boolean getEndangered() {
        return isEndangered;
    }

    public Animal setEndangered(Boolean endangered) {
        isEndangered = endangered;
        return this;
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
