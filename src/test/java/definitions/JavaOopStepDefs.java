package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaOopStepDefs {

    private Home home = null;

    @Given("I have a home")
    public void createHome() {
        home = new Home();
    }

    @When("I add {string}")
    public void addFamilyMember(String name) {
        home.addFamilyMember(new FamilyMember(new Person(name)));
    }

    @And("I add cat {string}")
    public void addCat(String name) {
        home.addFamilyMember(new FamilyMember(new Cat(name)));
    }

    @Then("there are {int} family members")
    public void checkNumOfFamilyMembers(int count) {
        assertThat(home.getFamilyMembers().size()).isEqualTo(count);
    }

    @Given("I work with animal classes")
    public void iWorkWithClasses() {
        System.out.println();

        Animal cat = new Cat("Tom");
        cat.sleep();
        cat.walk();
        cat.speak();
        cat.eat("fish");
        System.out.println(cat.getName());
        System.out.println();

        Animal anotherCat = new Cat();
        anotherCat.sleep();
        anotherCat.speak();
        System.out.println("Street cat name is " + anotherCat.getName());
        System.out.println();

        Animal dog = new Dog();
        System.out.println("Dog name is " + dog.getName());
        dog.setName("Bobby");
        dog.eat("bone");
        dog.sleep();
        dog.speak();

        Animal parrot = new Parrot();

        List<Animal> animals = new ArrayList<>(Arrays.asList(cat,anotherCat,dog,parrot));
        printAnimalNames(animals);
        printAnimalEmoji(animals);
    }

    void printAnimalNames(List<Animal> animals) {
        System.out.println();
        System.out.println("All animal names >>>> ");
        for (Animal animal : animals) {
            System.out.println(animal.getName());
            animal.sleep();
            animal.speak();
        }
    }

    void printAnimalEmoji(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.print(animal+" ");
        }
        System.out.println("\b"); // backspace removes one char, not unicode character
    }

    @And("I print all home lists of members")
    public void iPrintAllHomeListsOfMembers() {
        System.out.println(home);
    }

    @And("I add dog {string}")
    public void addDog(String name) {
        home.addFamilyMember(new FamilyMember(new Dog(name)));
    }
}