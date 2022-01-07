package definitions;

import io.cucumber.java.en.Given;
import pages.Animal;

public class AnimalStepDefs {
    @Given("I work with Animal class")
    public void iWorkWithAnimalClass() {
        Animal animal = new Animal("George");
        animal.sleep();
        animal.speak();
        animal.eat("turkey");
        animal.walk();
        animal.fly();
        animal.swim();
        System.out.println(animal.getName());

        Animal anotherAnimal = new Animal();
        anotherAnimal.sleep();
        anotherAnimal.speak();
        anotherAnimal.eat("meat");
        anotherAnimal.walk();
        animal.fly();
        animal.swim();
        System.out.println(anotherAnimal.getName());
    }
}
