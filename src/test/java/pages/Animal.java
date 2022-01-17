package pages;

public class Animal {

        //    fields
        protected String name;

        //    constructor (Static polymorphism)

        public Animal() {
            setName("nameless"); // if we want to not name the Car() empty blanks in JavaStepDefs.java
        }

        public void setName(String newName) {
            if (!newName.isEmpty() && !newName.equals("Jerry")) {
                name = newName;
            } else {
                throw new Error("Unacceptable name! " + newName);
            }
        }

        public String getName() {
            return name;
        }

        //    methods
        public void walk() {
            System.out.println(getClass()+ " " + name + " is walking!");
        }

        public void sleep() {
            System.out.println(getClass()+ " " + name + " is sleeping");
        }

        public void eat(String what) {
            System.out.println(getClass()+ name + " is eating" + " "+ what +" " + "!");
        }

        public void speak () {
            System.out.println("Animal tries to speak!!!");
        }

}
