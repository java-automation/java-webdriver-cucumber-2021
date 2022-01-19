package pages;

public class Cat  extends Animal {

    //constructors
    public Cat(String newName) {
        //name = newName;
        setName(newName);
    }

    public Cat() {
    }

    public void speak()  {
        System.out.println("Cat " + name + " is meowing");
    }
}
