package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class JavaStepDefs {
    @Given("I write in Java")
    public void iWriteInJava() {
        System.out.println("Hello Java!");
    }


    @And("I go wild {string}")
    public void iGoWild(String arg0) {
        System.out.println(arg0);
    }

    @Given("They say {string}")
    public void theySay(String message1) {
        System.out.println(message1);
    }

    @When("I say {string} {string}  {string}")
    public void iSay(String firstName, String lastName, String favColor) {

            System.out.println(firstName +" "+ lastName +" " +favColor);
            //reusable, but then better keep arg1-arg3
    }

    @Given("Kitty likes to play with {string}")
    public void kittyLikesToPlayWith(String str) {

        System.out.println(str.toUpperCase());
        System.out.println(str.length());
        System.out.println(str.toLowerCase());
        System.out.println(str.trim());
        System.out.println(str.charAt(0));
        System.out.println(str.contains("ing"));
        System.out.println(str.isEmpty());
        System.out.println(str.indexOf(5));
        System.out.println(str.indexOf("r"));
        System.out.println(str.getClass());
        System.out.println(str);
        System.out.println(str.substring(1,3));


    }

    @And("{string} is {string}")
    public void is(String name1, String name2) {

        System.out.println(name1);
        System.out.println(name2);

        System.out.println(name1.toUpperCase());
        System.out.println(name2.toUpperCase());

        System.out.println(name1.length());
        System.out.println(name2.length());

        System.out.println(name1.compareTo(name2));//check Unicode values 4 Upper and lower case char

        System.out.println(name2.compareTo(name1));//as expected,different result

        System.out.println(name1.contains(name2));

        System.out.println(name1.contentEquals(name2));

        System.out.println(name1.getClass());

        System.out.println(name1.matches(name2));

        System.out.println(name1.equalsIgnoreCase(name2));
        System.out.println(name1.compareToIgnoreCase(name2));



    }

    @Then("Humpty Dumpty fell off the wall")
    public void humptyDumptyFellOffTheWall() {
        String firstName="Humpty ";//space on purpose 4 checking trim() and concat()
        String lastName ="Dumpty";

        System.out.println("His name is " + firstName.concat(lastName));//one way
        System.out.println("And " + firstName + lastName + " fell off the wall");//another way
        System.out.println(firstName.trim()+" is now just a part of him");
        //checking how .trim() works
    }

    @Given("I play with numbers")
    public void iPlayWithNumbers() {
        int num1 = 17;
        int num2 = 32;

        double num3 = num2/17.0;

        int sum = num1+num2;
        int difference1= num1-num2;
        int difference2=num2-num1;
        int quotient=num2/num1;
        int product=num1*num2;
        int modulus = num2%num1;

        System.out.println("The sum of numbers is " +sum);
        System.out.println("The result of num1-num2 is " +difference1);
        System.out.println("The result of num2-num1 is " +difference2);
        System.out.println("The result of num2/num1 is " +quotient);
        System.out.println("The result of num2/17.0 is " +num3);
        System.out.println("The result of num2%num1 is " +modulus);
        System.out.println("The result of num1*num2 is " +product);
    }

    @Given("I check boolean data type")
    public void iCheckBooleanDataType() {
        int a=65;
        int b=87;
        System.out.println(a==b);
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a!=b);
        System.out.println(a>=0);
        System.out.println(a+b<=a);
        System.out.println(b-a<b && b-a!=b/a);

        boolean c=true;
        boolean d=false;
        System.out.println(c);
        System.out.println(!c);
        System.out.println(!c==d);
    }

    @When("I try it with string {string}")
    public void iTryItWithString(String favColor) {
        String notFavColor="pink";

        System.out.println(favColor == notFavColor);
        System.out.println(favColor != notFavColor);
        // it should not be used w strings ? Confusing?
        // comparison by value in THIS case since no objects were created ?
        System.out.println(favColor.equals(notFavColor));

        String d= new String("green");
        String d1=new String("green");
        System.out.println(d==d1); //false <-> reference dif objects
        //comparison by reference to the objects
        d1=d;
        System.out.println(d==d1); //true <-> reference to the same object
        System.out.println(d.equals(d1)); //true
        // string method .equals overrides object.equals

        if (favColor.equalsIgnoreCase("green") || favColor.equalsIgnoreCase("orange") || favColor.equalsIgnoreCase("burgundy") || favColor.equalsIgnoreCase("blue")){
            System.out.println(favColor+ " is one of my favorite colors");
        } else if (favColor.equals(notFavColor)){
            System.out.println(notFavColor+ " is not my favorite color");
        } else {
            System.out.println("I like color " + favColor);
        }

    }

    @Given("I compare {string} and {string} strings")
    public void iCompareAndStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println("Strings "+str1+ " and "+str2+" are equal");
        } else if (str1.contains(str2)){
            System.out.println("String "+str2 +" is part of string "+str1);
        } else {
            System.out.println("Strings "+str1 +" and "+str1+" are not equal");
        }
    }

    @Given("I print url for {string}")
    public void iPrintUrlFor(String siteName) {
        if (siteName.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com/");
        }else if(siteName.equalsIgnoreCase("quote")){
            System.out.println("https://skryabin.com/market/quote.html");
        }else {
            System.out.println("Url for website " + siteName +" is unknown");
        }
    }

//    @Given("I work with regex and {string}")
//    public void iWorkWithRegexAnd(String text) {
//        String re=".";//matches ANY SINGLE character!!!  [("...") will match input of 3 char=>true]
//        re = "\\w\\w"; //matches any word char (letters,numbers, _(Undescore)). "\\w" => True if text contains SINGLE char
//        re = "\\W"; // matches NOT A WORD(+numbers and underscore) char. TRUE in case of SPECIAL CHARs, including whitespace
//        re = "\\w\\W"; //TRUE in case "R%" or "9$"  - examples
//        re= "\\w\\W."; //word char followed by non word char followed by ANY char (.). Example "9$a" (or "9$ ") => TRUE
//        re =".\\s\\w"; // "\s" - WHITESPACE char, TAB, NEW LINE.. Exampe "b 9" => TRUE. !!{re =".\\s\\w"}!! also TRUE here
//        re= ".\\S\\w"; // "\S" NON WHITESPACE char. Exmpl : "b 9" => FALSE , but " b9"=>TRUE
//        re ="\\d\\d\\W"; // "\d" ANY DIGIT [0-9]. EXMPL : "67-"=> TRUE
//        re="\\d\\W\\d\\W.."; // EXMPL : "5+6=11" => TRUE
//        re ="\\D"; // "\D" NON DIGIT. anything that is NOT[0-9] will return FALSE
//
//        re=".*"; // [0 or more ] matches ANYTHING(OR NOTHING), literally "ANY char 0 or more times"..EXMPL :"b"=>TRUE,
//        // "" (empty str) => True, "bbb"=>TRUE, "b 5"=> True {except a newline ?}-CHECK
//
//        re=".+"; //matches AT LEAST ONE OF ANYTHING. [1 or more]
//        // EXMPL : "b 7" ->True; "b"->True; " "->True; ""-> False
//
//        re="\\d*"; // Matches SERIES OF DIGITS OR NOTHING [either empty or digits[0-9]]
//        //EXMPL: ""-> True; "34567" ->True; "345ab" -> False
//        re="[0-9]*"; // SAME AS ABOVE  EXMPL: "345" ->True; "" ->True; 345ab -> false
//
//        re="\\d+"; // MATCHES 1 OR MORE DIGITS
//        //EXMPL: ""-> False; "34567" ->True; "345ab" -> False
//        re="[0-9]+"; // SAME AS ABOVE
//        // "7"-> True
//
//        re="[an?]"; // MATCHES A or AN (? MAKES N OPTIONAL)
//        //?!!!! WHY EXMPL : "an" -->False; "a" -> True;
//        // CHECK SYNTAX !!!!!!
//
//        re="[an]?";
//        // ?!!!!!! "a"=> True, "an"=> False
//
//        re="\bla"; // \b- Word Boundary
//        // ?!!!! Syntax  Exmpl "lala la"
//
//        // re="\\Bla"; // \B - NOT a word Boundary
//
//        //re="[sun]";
//        // ?!!!! why FALSE for "sun sunshine" ?!
//
//        //re="[^s]";
//        // ???!!!!! doesn't work
//        // WORKS!!!! but only for the link w 1 char : "S". Then ->True
//
//        Pattern pt = Pattern.compile(re);
//        Matcher mt =pt.matcher(text);
//        // Pattern class doesn't have a public constructor
//        // It only has a static Method called Complile
//
//        boolean result = mt.matches();
//
//        System.out.println(result); // to be TRUE for text=Regular Expressions String re should be ="....(19 dots)"
//        System.out.println(mt); // experiment.
//    }

    @Given("I check if number {int} is positive")
    public void iCheckIfNumberIsPositive(int num) {
        if (num>0){
            System.out.println("Number "+"\""+ num+"\" is positive");
        } else if (num<0) {
            System.out.println("Number "+"\""+ num+"\" is negative");
        } else {
            System.out.println("Number "+"\""+ num+"\" is neither negative nor positive");

        }

    }

    @And("I print {int} day of the week")
    public void iPrintDayOfTheWeek(int day) {
        switch (day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("There is no such day of week");
        }

    }

    @And("I print {int} day of the week with enhanced switch")
    public void iPrintDayOfTheWeekWithEnhancedSwitch(int day) {

        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("There is no such day of week");
        }
    }

    @And("I print {int} day of the week using array")
    public void iPrintDayOfTheWeekUsingArray(int day) {
        String[] daysOfWeek ={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        if (day<7 && day>= 0) {
            System.out.println(daysOfWeek[day]);
        } else {
            System.out.println("input numbers from 0 to 6");
        }
    }

    @And("I check if number {int} is even or odd")
    public void iCheckIfNumberIsEvenOrOdd(int num) {
        int mod = num%2;

        if (mod ==0){
            System.out.println("Number "+'\"' + num +'\"'+" is even");
        } else {
            System.out.println("Number "+'\"' + num +'\"'+" is odd");
        }
    }
}
