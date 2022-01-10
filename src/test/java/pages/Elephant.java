package pages;

public class Elephant  extends Animals {

    //constructor (assign properties/fields):
    public Elephant(String newName) {
        name = newName;
    }

    @Override
    public void speak(){
        System.out.println("The elephant knows how to laugh! :) ");
    }
}