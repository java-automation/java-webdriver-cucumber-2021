package pages;

public class Tiger extends Animals{

// constructor
    public Tiger(String newName) {
        name = newName;
    }

        public  void speak() {

        System.out.println("Tiger " + name + " is growling");
    }
    @Override
    public void sleep(){
        System.out.println("Tiger doesn't sleep a lot");
    }

}


