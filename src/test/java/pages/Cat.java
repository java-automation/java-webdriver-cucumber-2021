package pages;

public class Cat extends Animal {

    public Cat(String newName){
        setName(newName);
    }

    public Cat(){
    }
    @Override
    public void speak(){
        System.out.println("Cat " + name + " is meowing");
    }
}
