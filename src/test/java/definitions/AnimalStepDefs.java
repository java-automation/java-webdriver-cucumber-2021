package definitions;

import io.cucumber.java.en.Given;
import pages.Animal;
import pages.Cat;
import pages.Dog;
import pages.Parrot;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class AnimalStepDefs {
    @Given("I work with classes")
    public void iWorkWithClasses() {

        out.println();
        out.println();

        Animal cat = new Cat("Tom", 6.0, 3.0, 2.0, false, 4, true, false);
        cat.sleep();
        cat.walk();
        cat.speak();
        cat.eat("fish");
        cat.fly();
        out.println(cat.getName());

        out.println();

        Animal anotherCat = new Cat();
        anotherCat.sleep();
        anotherCat.speak();
        anotherCat.fly();
        out.println("Street cat name is " + anotherCat.getName());

        out.println();
        out.println();

        Animal dog = new Dog();
        out.println("Dog name is " + dog.getName());
        dog.setName("Bobby");
        dog.eat("bone");
        dog.sleep();
        dog.speak();
        dog.fly();

        Animal parrot = new Parrot();
        out.println("Parrot name is " + parrot.getName());
        parrot.setName("Kesha");
        parrot.eat("seeds");
        parrot.fly();
        parrot.speak();

        Animal tiger = new Cat()
                .setName("Tigger")
                .setAge(4.5)
                .setDomestic(false)
                .setWeight(56.7)
                .setHeight(120.5)
                .setWings(false)
                .setHeight(120.6)
                .setHowManyLegs(4)
                .setDomestic(false)
                .setEndangered(true);
        out.printf("%s %s %s %s%n", "Tiger:", tiger.getName(), tiger.getAge(), tiger.getDomestic());
        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(anotherCat);
        animals.add(dog);
        animals.add(parrot);
        animals.add(tiger);
        printAnimalNames(animals);
    }

    void printAnimalNames(List<Animal> animals) {
        System.out.println();
        System.out.println("All animal names >>>> ");
        for (Animal animal : animals) {
            System.out.println(animal.getName());
            animal.sleep();
            animal.speak();
            animal.fly();
            if (animal.getEndangered() != null && animal.getEndangered().equals(true)) {
                out.println(animal.getName() + " is endangered!");
            }
        }
    }
}

