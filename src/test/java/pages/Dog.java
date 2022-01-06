package pages;

public class Dog extends Animal {

    public Dog() { super(); }

    public Dog(String newName) { super(newName); }

    @Override
    public void setName(String newName) {
        if (newName.equals("Tom") || newName.equals("Jerry")) throw new Error("Unacceptable dog name! " + newName);
        super.setName(newName);
    }

    public void bark() {
        System.out.println("Dog " + this.getName() + " is barking!");
    }
}
