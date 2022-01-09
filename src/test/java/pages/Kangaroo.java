package pages;

import java.util.List;

public class Kangaroo extends Animal {

    // constructor
    public Kangaroo(String newName) {
        setName(newName);
    }

    // methods
    public void eat(String what) {
        List<String> meal = List.of("sushi", "onion", "and some food");
        if (meal.contains(what.toLowerCase())) {
            System.out.println("Kangaroo " + name + " is eating " + what + ", but without pleasure!");
        } else {
            System.out.println("Kangaroo " + name + " is eating " + what + "!");
        }
    }

    public void speak() {
        System.out.println("Kangaroo " + name + " is aghrrrring!");
    }
}
