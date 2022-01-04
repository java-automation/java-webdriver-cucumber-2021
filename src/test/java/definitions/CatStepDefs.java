package definitions;

import io.cucumber.java.en.Given;
import pages.Cat;

public class CatStepDefs {
    @Given("I work with classes")
    public void iWorkWithClasses() {
        Cat cat = new Cat("Tom");
        cat.sleep();
        cat.speak();
        cat.eat("chicken");
        cat.walk();
        System.out.println(cat.getName());

        Cat anotherCat = new Cat();
        anotherCat.sleep();
        anotherCat.speak();
        anotherCat.eat("fish");
        anotherCat.walk();
        System.out.println(anotherCat.getName());

    }
}
