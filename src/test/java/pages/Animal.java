package pages;

public class Animal {
    protected String name;
    protected String color;
    protected String type;
    protected String size;

    //constructor
    public Animal(String newName) {
        setName(newName);
    }
    public Animal() {
        name = "nameless";
    }

    //methods
    public void setName(String newName) {
        if(!newName.isEmpty() && !newName.equals("Jerry")) {
            name = newName;
        } else {
            throw new Error("Unacceptable name! " + newName);
        }
    }

    public String getName() {
        return name;
    }

    public void setColor(String newColor) {
        color = newColor;
    }
    public String getColor() {
        return color;
    }
    public void setType(String newType) {
        type = newType;
    }
    public String getType() {
        return type;
    }
    public void setSize(String newSize) {
        size = newSize;
    }
    public String getSize() {
        return size;
    }

    public void walk() {
        System.out.println(getClass() + " " + name + " is walking!");
    }

    public void sleep() {
        System.out.println(getClass() + " " + name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println(getClass() + " " + name + " is eating " + what + "!");
    }

    public void speak() {
        System.out.println("Animal tries to speak");
    }
}
