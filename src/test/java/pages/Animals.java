package pages;

public class Animals {
    //fields --- like text fileds First name /Last Name/ Age etc
    protected String name;

    // constructor
    public Animals() {
        setName("nameless one");
    }

    //methods
    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry")) {
            name = newName;
        } else {
            throw new Error("Unacceptable name! " + newName);
        }
    }
    //methods

    public String getName() {
        return name;
    }
    public void sleep() {
        System.out.println(getClass() + " " + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println(getClass() + " " + name + " is eating " + what + " !");
    }

    public void walk() {
        System.out.println( getClass() + " " + name + " is walking");
    }


    public void speak() {

    }

}

