package pages;

public class Cat extends Animal {

    public Cat() { super(); }

    public Cat(String newName) { super(newName); }

    @Override
    public void setName(String newName) {
        if (newName.equals("Jerry") || newName.equals("Spike")) throw new Error("Unacceptable cat name! " + newName);
        super.setName(newName);
    }

    public void meow() {
        System.out.println("Cat " + this.getName() + " is meowing!");
    }
}
