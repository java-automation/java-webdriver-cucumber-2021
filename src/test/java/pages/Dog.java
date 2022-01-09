package pages;

public class Dog extends Animal {

    public Dog(String name, int age) {
        setName(name);
        setAge(age);
    }

    @Override
    public void setName(String name) {
        if (name.equals("Tom") || name.equals("Jerry")) throw new Error("Unacceptable dog name! " + name);
        super.setName(name);
    }

    public void speak() {
        System.out.println("Dog '" + getName() + "' is barking!");
    }
}
