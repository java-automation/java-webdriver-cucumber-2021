package pages;

public class Animal {
    // fields
    protected String name; // it should be private and use get and set methods to access it!
    protected int weight;

    public Animal () { // static polymorphism
        setName("Nameless one");
    }
    public int getWeigh() {
        return weight;
    }
    public void setWeigh(int weight) {
        this.weight = weight;
    }

    public void setName (String newName) {
        if (!newName.isEmpty()) {
            name = newName;
        } else {
            throw new Error("Unacceptable empty name!" );
        }
    }

    public String getName () {
        return name;
    }

    // methods
    public void walk () {
        System.out.println(getClass() +" " + name + " is walking");
    }
    public void sleep () {
        System.out.println(getClass() +" " + name + " is sleeping");
    }
    public void eat (String food) {
        System.out.println(getClass() +" " + name + " is eating " + food + "!");
    }
    public void swim () {
        System.out.println(getClass() +" " + name + " is swimming");
    }
    public void speak () {
        System.out.println("Animal tries to speak: ");}
    public void bite () {
            System.out.println("Animal can bite you!: ");
        }
}

