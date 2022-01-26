package pages;

public class Cat extends Animal {

    public Cat (String newName) {
        setName(newName);
    }
    public Cat () { // this one blank as it will use one from Animal!
    }

    @Override
    public void speak () {
        System.out.println("Cat " + name + " is meowing ");
    }

}
