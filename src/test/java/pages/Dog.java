package pages;

public class Dog {

    private String name; //private

    //public methods - encapsulation
    public String getName() {
        return name;
    }

    public void setName (String name) {
        if (name.isEmpty() || name.equals("Basilio")) {
            throw new Error("Unacceptable name! " + name);
        }
        this.name = name;
    }

    // constructor
    public Dog() {
        setName("Nameless dog");
    }
    public Dog (String name) {

        setName(name);
    }

    //methods
    public void walk () {
        System.out.println("Dog " + name + " is walking");
    }
    public void sleep () {
        System.out.println("Dog " + name + " is sleeping");
    }
    public void eat (String food) {
        System.out.println("Dog " + name + " is eating " + food + "!");
    }
    public void speak () {
        System.out.println("Dog " + name + " is barking ");
    }
}
