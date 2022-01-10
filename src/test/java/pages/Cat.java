package pages;

public class Cat {
    //fields
    private String name; //advised to use private. this is encapsulation.

    //constructor
    public Cat(String newName) {
        setName(newName);
    }
    public Cat() {
        setName("nameless one");
    }

    public void setName(String newName) {
        if(!newName.isEmpty() && !newName.equals("Jerry")){
            name = newName;
        }else{
            throw new Error("Unacceptable name! " + newName);
        }
    }
    public String getName(){
        return name;
    }

    //methods
    public void walk() {
        System.out.println("Cat " + name + " is walking");
    }

    public void eat(String what) {
        System.out.println("Cat " + name + " is eating " + what + "!");
    }
    public void speak(){
        System.out.println("Cat " + name + " is meowing");
    }
    public void sleep(){
        System.out.println("Cat " + name + " is sleeping");
    }
}