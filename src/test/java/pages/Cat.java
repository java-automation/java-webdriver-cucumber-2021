package pages;

public class Cat extends Animal {

    public Cat() { super(); }

    public Cat(String newName) { super(newName); }

    @Override
    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry") && !newName.equals("Spike")) {
            super.setName(newName);
        } else {
            throw new Error("Unacceptable cat name! " + newName);
        }
    }

    public void speak() {
        System.out.println("Cat " + this.getName() + " is meowing!");
    }
}
