package pages;

public abstract class Animal {

    private String name;
    private int age;

    private String className;

    public Animal() {
        setClassName();
        setName("nameless");
        setAge(0);
        System.out.println("New 'nameless' " + this.className + ", 0 years old!");
    }

    public Animal(String newName) {
        setClassName();
        setName(newName);
        setAge(0);
        System.out.println("New " + this.className + " - '" + this.name + "', 0 years old!");
    }

    public Animal(String newName, int age) {
        setClassName();
        setName(newName);
        setAge(age);
        System.out.println("New " + this.className + " - '" + this.name + "', " + this.age + " years old!");
    }

    public void setName(String name) {
        if (name.isEmpty()) throw new Error("Empty animal name!");
        if (this.name != null) {
            System.out.println(this.className + " '" + this.name + "' has been adopted as '" + name + "'!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk() {
        System.out.println(this.className + " '" + this.name + "' is walking!");
    }

    public void sleep() {
        System.out.println(this.className + " '" + this.name + "' is sleeping!");
    }

    public void eat(String what) {
        System.out.println(this.className + " '" + this.name + "' is eating " + what + "!");
    }

    public void birthday() {
        setAge(++this.age);
        System.out.println(this.className + " '" + this.name + "' has a birthday! Now " + this.age + " years old!");
    }

    public void birthday(Animal[] friends) {
        birthday();
        System.out.println("Friends attended:");
        for (Animal a : friends) {
            System.out.println(" - " + a.className + " '" + a.getName() + "', " + a.getAge() + " years old");
        }
    }

    public abstract void speak();

    private void setClassName() {
        String fullClassName = getClass().getName();
        className = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
    }
}
