package pages;

public class Dog {
    //fields
    private String name;

    //constructor
    public Dog(String newName){
        setName(newName);

    }

    private void setName(String newName) {
        if(!newName.isEmpty() && !newName.equals("TEDDY")){
            name = newName;
        }else{
            throw new Error("Unacceptable name! " + newName);
        }
    }

    //methods
    public void walk(){
        System.out.println("Dog " + name + " is walking!");
    }
    public void eat(String what){
        System.out.println("Dog " + name + " is eating " + what + "!");
    }
    public void speak(){
        System.out.println("Dog " + name + " is barking!");
    }
    public void sleep(){
        System.out.println("Dog " + name + " is sleeping!");
    }



}
