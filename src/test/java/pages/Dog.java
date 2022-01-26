package pages;

public class Dog extends Animal{
    // constructor

    public Dog (String name) {
        setName(name);
    }
    public Dog () {
    }
    //methods
    @Override
    public void speak () {
        System.out.println("Dog " + name + " is barking ");
    }
}
