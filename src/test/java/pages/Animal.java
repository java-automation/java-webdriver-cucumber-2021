package pages;

import java.util.Objects;

public abstract class Animal {

    private String name;
    private int age;

    private final String className;

    public Animal() {
        className = getClass().getSimpleName();
        System.out.println("New " + className + "!");
        name = "nameless";
        age = 0;
    }

    public void setName(String name) {
        if (name.isEmpty()) throw new Error("Empty animal name!");
        this.name = name;
        System.out.println("This " + className + " is now known as '" + this.name + "'!");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < this.age) throw new Error("Haven't invented time machine yet!");
        this.age = age;
        System.out.println(className + " '" + name + "' is " + getAgeAsString() + "!");
    }

    public void walk() {
        System.out.println(className + " '" + name + "' is walking!");
    }

    public void sleep() {
        System.out.println(className + " '" + name + "' is sleeping!");
    }

    public void eat(String what) {
        System.out.println(className + " '" + name + "' is eating " + what + "!");
    }

    public void birthday() {
        System.out.println(className + " '" + name + "' has a birthday!");
        setAge(++age);
    }

    public void birthday(Animal[] friends) {
        birthday();
        System.out.println("Friends attended:");
        for (Animal a : friends) {
            System.out.println(" - " + a.className + " '" + a.getName() + "', " + a.getAgeAsString());
        }
    }

    public abstract void speak();

    private String getAgeAsString() {
        return (age == 1) ? "1 year old" : age + " years old";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}