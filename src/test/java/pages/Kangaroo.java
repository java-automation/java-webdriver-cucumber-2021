package pages;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Locale;

public class Kangaroo {
    // fields
    private String name;

    // constructor
    public Kangaroo(String newName) {
        setName(newName);
    }
    public Kangaroo() {
        setName("nonKangaroo");
    }

    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Anna")) {
            name = newName;
        } else {
            throw new Error ("Unnacceptable name! " + newName);
        }
    }

    public String getName() {
        return name;
    }

    // methods
    public void jump() {
        System.out.println("Kangaroo " + name + " is jumping away!");
    }

    public void sleep() {
        System.out.println("Kangaroo " + name + " is sleeping!");
    }

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

    public void drink(String someDrink) {
        List<String> drinks = List.of("dark beer");
        if (drinks.contains(someDrink.toLowerCase())) {
            System.out.println("Kangaroo " + name + " is drinking " + someDrink + "!");
        } else {
            System.out.println("Kangaroo " + name + " is drinking " + someDrink + " and looks at you judgmental!");
        }
    }
}
