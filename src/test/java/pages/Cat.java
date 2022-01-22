package pages;

public class Cat {
    // fields
    private String name; // it should be private and use get and set methods to access it!

    //constructor
    public Cat (String newName) { // constructor - 'new Cat'. this constructor method is always public!!
        setName(newName);
    }
    public Cat () { // static polymorphism

        setName("Nameless Cat");
    }

    public void setName (String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry")) {
            name = newName;
        } else {
            throw new Error("Unacceptable name! " +newName);
        }
    }
//    public void setName (String name) {
//        if (!name.isEmpty() && !name.equals("Jerry")) {
//            this.name = name;
//        } else {
//            throw new Error("Unacceptable name! " +name);
//        }
//    }
    public String getName () {
        return name;
    }

    // methods
    public void walk () {
        System.out.println("Cat " + name + " is walking");
    }
    public void sleep () {
        System.out.println("Cat " + name + " is sleeping");
    }
    public void eat (String food) {
        System.out.println("Cat " + name + " is eating " + food + "!");
    }
    public void speak () {
        System.out.println("Cat " + name + " is meowing ");
    }
}
