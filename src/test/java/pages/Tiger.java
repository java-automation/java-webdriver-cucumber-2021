package pages;

public class Tiger {

    private String name;


    public Tiger(String tigerName) {  //constructor

        name = tigerName;
    }
    public Tiger() {       //constructor
        setName("no name");
    }

    public void setName(String tigerName){
        if(!tigerName.isBlank() && !tigerName.contains("Boris")){

           name = tigerName;
        } else {
            throw new Error("Unacceptable name " + tigerName);
        }

    }

    public  String getName() {
        return name;
    }

    public void hunt() {
        System.out.println("Tiger " + name + " is hunting");
    }

    public void sleep(){
        System.out.println("Tiger " + name + " is sleeping");
    }

    public void mate(){
        System.out.println("Tidier " + name + " is mating" );
    }

    public void play(){
        System.out.println("Tiger " + name + " is playing");
    }
}


