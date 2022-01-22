package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.Cat;
import pages.Dog;
import pages.Fish;

public class JavaStepDefsOop {
    @Given("I work with classes")
    public void iWorkWithClasses() {
        Cat cat = new Cat("Basilio");
        System.out.println(cat.getName());
        cat.sleep();
        cat.walk();
        cat.eat("fish");
        cat.speak();
        cat.setName("newCatName");
        cat.sleep();

        Cat anotherCat = new Cat();
        System.out.println(anotherCat.getName());
        anotherCat.sleep();
        anotherCat.walk();
        anotherCat.eat("milk");
        anotherCat.speak();
        cat.setName("newCatName");
        cat.sleep();
    }
    @Given("I work with Dog classes")
    public void iWorkWithDogClasses() {
        Dog firstDog = new Dog();
        System.out.println(firstDog.getName());
        firstDog.eat("dog food");
        firstDog.sleep();
        firstDog.walk();
        firstDog.speak();
        firstDog.setName("Happy dog with name");
        firstDog.speak();

        Dog secondDog = new Dog("Belka");
        secondDog.speak();
        secondDog.walk();
        secondDog.eat("anything");
        secondDog.setName("Good dog");
        secondDog.walk();
    }

    @And("I work with Fish classes")
    public void iWorkWithFishClasses() {
        Fish fish = new Fish("Little fish");
        fish.swim();
        fish.eat("fish food");
        fish.setName("");
        fish.eat("fish food");

        Fish newFish = new Fish("Big fish");
        System.out.println(newFish.getName());
        newFish.swim();
        newFish.eat("any fish food");
        newFish.sleep();
        newFish.setName("New fish name");
    }

}
