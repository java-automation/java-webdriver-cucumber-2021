package pages;


public abstract class Animal {
    // fields
    protected String name;
    protected String color;
    protected int paws;
    protected boolean bag;

    // constructor
    public Animal() {
        setName("nameless one");
        setColor("black");
        setPaws(4);
        setBag(false);
    }

    // methods
    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry")) {
            name = newName;
        } else {
            throw new Error("Unacceptable name! " + newName);
        }
    }

    public void setColor(String newColor) {
        color = newColor.toLowerCase();
    }

    public void setPaws(int pawsCount) {
        paws = pawsCount;
    }

    public void setBag(boolean isBag) {
        bag = isBag;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getPaws() {
        return paws;
    }
    public boolean hasBag() {
        return bag;
    }

    public void walk() {
        System.out.println(getClass().getName().replace(getClass().getPackageName() + ".", "") + " " + name + " is walking!");
    }

    public void sleep() {
        System.out.println(getClass().getName().replace(getClass().getPackageName() + ".", "") + " " + name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println(getClass().getName().replace(getClass().getPackageName() + ".", "") + " " + name + " is eating " + what + "!");
    }

    public void jump() {
        System.out.println(getClass().getName().replace(getClass().getPackageName() + ".", "") + name + " is jumping away!");
    }


    public abstract void speak();
}
