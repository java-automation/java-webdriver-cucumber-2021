package pages;

public class Cat extends Animal {

    public Cat() {}

    public Cat(String name) {
        setName(name);
    }

    @Override
    public void setName(String name) {
        if (name.equals("Jerry") || name.equals("Spike")) throw new Error("Unacceptable cat name! " + name);
        super.setName(name);
    }

    public void speak() {
        System.out.println("Cat '" + getName() + "' is meowing!");
    }
}
