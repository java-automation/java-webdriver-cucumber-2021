package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.Animal;
import pages.Cat;
import pages.Dog;
import pages.Fish;

import java.util.ArrayList;
import java.util.List;

public class JavaStepDefsOop {
    @Given("I work with classes")
    public void iWorkWithClasses() {
        Animal cat = new Cat("Basilio");
        System.out.println(cat.getName());
        cat.sleep();
        cat.walk();
        cat.eat("fish");
        cat.speak();
        cat.setName("newCatName");
        cat.sleep();

        Animal anotherCat = new Cat();
        System.out.println(anotherCat.getName());
        anotherCat.sleep();
        anotherCat.walk();
        anotherCat.eat("milk");
        anotherCat.speak();
        cat.setName("newCatName");
        cat.sleep();

        Animal firstDog = new Dog();
        System.out.println(firstDog.getName());
        firstDog.eat("dog food");
        firstDog.sleep();
        firstDog.walk();
        firstDog.speak();
        firstDog.setName("Happy dog with name");
        firstDog.speak();

        Animal secondDog = new Dog("Belka");
        secondDog.speak();
        secondDog.walk();
        secondDog.eat("anything");
        secondDog.setName("Good dog");
        secondDog.walk();

        Animal catTest = new Cat("Test Cat");
        System.out.println(catTest.getName());
        catTest.setWeigh(5);
        System.out.println(catTest.getWeigh());
        catTest.bite();

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(anotherCat);
        animals.add(firstDog);
        animals.add(secondDog);
        printAnimals(animals);

    }

    void printAnimals(List<Animal> animals) {
        System.out.println();
        System.out.println("All animal names >>>>>");
        for (Animal animal :animals) {
            System.out.println(animal.getName());
        }
    }

    @And("I work with Fish classes")
    public void iWorkWithFishClasses() {
        Fish fish = new Fish("Little fish");
        fish.swim();
        fish.eat("fish food");
        fish.bite();

        Fish newFish = new Fish("Big fish");
        System.out.println(newFish.getName());
        newFish.swim();
        newFish.eat("any fish food");
        newFish.sleep();
        newFish.setName("New fish name");
    }

}
