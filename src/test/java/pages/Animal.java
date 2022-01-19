package pages;

public class Animal {
    //fields
    protected  String name;

    //constructor
    public Animal() {
        //name = newName;
        setName("nameless");
    }


    //getter and setter for using String name:
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (!newName.isEmpty() && !newName.equals("Jerry")) { //если имя непусто и не равно Jerry, то мы разрешаем совершать  дальнейшие действия (мы не разрешаем пустое поле или имя Jerry)
            name = newName;
        } else {
            throw new Error("Unacceptable name: " + newName);
        }
    }

    //methods
    public void walk() {
        System.out.println(getClass() + " " + name + " is walking");
    }

    public void sleep() {
        System.out.println(getClass() + " " + name + " is sleeping");
    }

    public void eat(String meal) {
        System.out.println(getClass() + " " + name + " is eating " + meal);
    }

    public void speak() {
        System.out.println("Animal is trying to speak!!!");
    }

//    public abstract void speak();

}
