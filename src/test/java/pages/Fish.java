package pages;

public class Fish {
    //fields
    private String name;

    public void setName(String newName) {
        if (newName.isEmpty()) {
            throw new Error("Bad (empty) name ");
        }

        if (name != null) {
            throw new Error("Can't rename! " + name);
        }

        name = newName;
    }

    public String getName() {
        return name;
    }

    //constructor
    public Fish() {
        setName("Nameless");
    }
    public Fish(String name) {
        setName(name);
    }

    //methods
    public void swim () {
        System.out.println("Fish " + name + " is swimming");
    }
    public void sleep () {
        System.out.println("Fish " + name + " is sleeping");
    }
    public void eat (String food) {
        System.out.println("Fish " + name + " is eating " + food + "!");
    }
}
