package pages;

public class Cat extends Animals{


    //constructor (assign properties/fields):

    public Cat(String newName) {
        name = newName;

    }

    public void speak(){
        System.out.println("Cat " + name + " is meowing");
    }

    @Override
    public void sleep(){
        System.out.println(" Cats sleep all the time!");
    }
}
