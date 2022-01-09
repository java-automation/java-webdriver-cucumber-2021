package pages;

public abstract class Animal {

    private String name;
    private int age;

    private String className;

    public Animal() {
        setClassName();
        System.out.println("New " + this.className + "!");
        name = "nameless";
        age = 0;
    }

    public void setName(String name) {
        if (name.isEmpty()) throw new Error("Empty animal name!");
        this.name = name;
        System.out.println("This " + this.className + " is now known as '" + this.name + "'!");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < this.age) throw new Error("Haven't invented time machine yet!");
        this.age = age;
        System.out.println(this.className + " '" + this.name + "' is " + getAgeAsString() + "!");
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
        System.out.println(this.className + " '" + this.name + "' has a birthday!");
        setAge(++this.age);
    }

    public void birthday(Animal[] friends) {
        birthday();
        System.out.println("Friends attended:");
        for (Animal a : friends) {
            System.out.println(" - " + a.className + " '" + a.getName() + "', " + a.getAgeAsString());
        }
    }

    public abstract void speak();

    private void setClassName() {
        String fullClassName = getClass().getName();
        className = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
    }

    private String getAgeAsString() {
        return (this.age == 1) ? "1 year old" : this.age + " years old";
    }
}
