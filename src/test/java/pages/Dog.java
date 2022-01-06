package pages;

public class Dog extends Animal {

    public Dog() { super(); }

    public Dog(String newName) { super(newName); }

    @Override
    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Tom") && !newName.equals("Jerry")) {
            super.setName(newName);
        } else {
            throw new Error("Unacceptable dog name! " + newName);
        }
    }

    public void speak() {
        System.out.println("Dog " + this.getName() + " is barking!");
    }
}
