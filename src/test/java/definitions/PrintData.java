package definitions;

public class PrintData {
    String defaultFirstName = "Lyn";
    String defaultLastName = "Gorfild";
    String defaultFavoriteColor = "Red";
    int num1 = 15;
    int num2 = 10;

    public void PrintTheData(String firstName, String lastName, String favoriteColor) {
        if(firstName == "" || lastName == "" || favoriteColor == "") {
            System.out.println("Hi, my name is " + this.defaultFirstName + " " + this.defaultLastName + ", my favorite color is " + this.defaultFavoriteColor + ".");

        } else {
            System.out.println("Hi, my name is " + firstName + " " + lastName + ", my favorite color is " + favoriteColor + ".");
        }
    }

    public void PrintToConsole(String firstVar, String secondVar) {
        System.out.println("First variable: " + firstVar);
        System.out.println("Second variable: " + secondVar);
    }

    public static void getNumbers(int n1, int n2) {
        int num1 = n1;
        int num2 = n2;
    }
}
