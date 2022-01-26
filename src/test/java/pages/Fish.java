package pages;

public class Fish extends Animal {
    public Fish (String newName) {
        setName(newName);
    }
    //methods


    @Override
    public void bite() {
        System.out.println("Fish usually doesn't bite");
    }
}
