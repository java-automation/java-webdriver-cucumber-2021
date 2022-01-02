package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaStepDefs {

    @Given("I hello world")
    public void iHelloWorld() {
        System.out.println("Hello World!");
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println(str1 + ", " + str2);
        System.out.println(str1.toUpperCase() + ", " + str2.toUpperCase());
        System.out.println(str1.length() + ", " + str2.length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains(str2));
    }

    @Given("I perform actions with numbers")
    public void iPerformActionsWithNumbers() {
        int num1 = 15;
        int num2 = 20;
        int sum = num1+num2;
        System.out.println("Sum: " + sum);
        int difference = num1-num2;
        System.out.println("Difference: " + difference);
        int quotient = num2/num1;
        System.out.println("Quotient: " + quotient);
        int product = num1*num2;
        System.out.println("Product: " + product);
    }

    @Given("I perform actions with boolean")
    public void iPerformActionsWithBoolean() {
        String notFavoriteColor = "orange";
        String color1 = "red";
        String color2 = "orange";
        System.out.println(color1.equals(notFavoriteColor));
        System.out.println(color2.equals(notFavoriteColor));
    }

    @Given("I compare {string} and {string} strings")
    public void iCompareAndStrings(String str1, String str2) {
        if(str1.equals(str2)) {
            System.out.println("Equal!");
        } else {
            System.out.println("Not equal!");
        }
    }


    @Given("I work with numbers {int} and {int}")
    public void iInteractWithNumbersAnd(int num1, int num2) {
        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);
        System.out.println(num1 % num2);
        if (num1 > num2) {
            System.out.println("Number 1 is bigger than number 2");
        } else if (num1 == num2) {
            System.out.println("Number 1 equals number 2");
        } else {
            System.out.println("Number 1 is less than number 2");
        }
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String page) {
//        if (page.equalsIgnoreCase("google")){
//            System.out.println("https://www.google.com/");
//        } else if (page.equalsIgnoreCase("yahoo")) {
//            System.out.println("https://www.yahoo.com/");
//        } else {
//            throw new Error("Unknown url for page: " + page);
//        }

        switch (page.toLowerCase()){
            case "google":
                System.out.println("https://www.google.com/");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com/");
                break;
            default:
                throw new Error("Unknown url for page: " + page);
        }
    }

    @And("I work with loops")
    public void iWorkWithLoops() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Mysh");
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num > 0) {
            System.out.println("Number is positive");
        } else if (num == 0) {
            System.out.println("Number equals 0");
        } else {
            System.out.println("Number is negative");
        }
    }

    @And("I print {int} day of week")
    public void iPrintDayOfWeek(int day) {
//        int mod = day % 7;
//        switch (mod) {
//            case 0:
//                System.out.println("Sunday");
//                break;
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            default:
//                System.out.println("The input is incorrect");
//        }

        String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(Arrays.toString(days));
        System.out.println(days[day-1]);
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] nums = {5, 7, 1, 0, 10};
        System.out.println(nums[2]);
        System.out.println(Arrays.toString(nums));
        for (int i =0; i < days.length; i++)
            System.out.print(days[i] + " ");
        System.out.println();

        System.out.println();
        List<String> daysList = new ArrayList<>();
        daysList.add("Monday");
        daysList.add("Tuesday");
        daysList.add("Wednesday");
        daysList.add("Thursday");
        daysList.add("Friday");
        daysList.add("Saturday");
        daysList.add("Sunday");
        System.out.println(daysList);

        for (String el : daysList)
            System.out.print(el + " ");

        List<String> weekList = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        System.out.println(weekList);

        List<Integer> numsList = new ArrayList<>();
        numsList.add(5);
        numsList.add(7);
        numsList.add(1);
        numsList.add(0);
        numsList.add(10);
        System.out.println(numsList);

    }

    @And("I print all numbers from 0 up to {int}")
    public void iPrintAllNumbersFrom0UpTo(int n) {
        for (int i = 0; i <= n; i++)
            System.out.print(i + " ");
    }

    @And("I print all numbers from {int} up to 0")
    public void iPrintAllNumbersFromUpTo0(int n) {
        for (int i = 0; i >= n; i--)
            System.out.print(i + " ");
    }

    @And("I print all integer array")
    public void iPrintAllIntegerArray() {
        int[] array = {2, 3, 7, 9, 12, 22, 49};
        System.out.println(Arrays.toString(array));
    }

    @And("I print all even numbers from integer array")
    public void iPrintAllEvenNumbersFromIntegerArray() {
        int[] array = {2, 3, 7, 9, 12, 22, 49};
        for(int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                System.out.print(array[i] + " ");
        }
    }

    @And("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        int[] emptyArray = {};
        if (emptyArray.length == 0)
            System.out.println("The array is empty");
        else
            System.out.println("The array is not empty");
    }

    @And("I check if array contains {int}")
    public void iCheckIfArrayContains(int num) {
        int[] array = {2, 3, 7, 9, 12, 22, 49};
        boolean numContains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                System.out.println("The array contains " + num);
                numContains = true;
                break;
            }
        }
        if(!numContains)
                System.out.println("The array doesn't contain " + num);
    }

    @And("I check if array contains {string}")
    public void iCheckIfArrayContains(String arg) {
        String[] strArray = {"yes", "no", "idk"};
        Boolean argContains = false;

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals(arg)) {
                System.out.println("The array contains " + arg);
                argContains = true;
                break;
            }
        }
        if(!argContains)
            System.out.println("The array doesn't contain " + arg);
    }

    @And("I work with java")
    public void iWorkWithJava() {
        int i = 3;
        int[] array = {2, 3, 7, 81, 11, 22, 24};
        Arrays.stream(array).sorted();

    }

    @Given("I swap two variables")
    public void iSwapTwoVariables() {
        int[] array = {2, 4, 7, 9, 22};
        int a = array[0];
        int b = array[4];
        array[0] = b;
        array[4] = a;
        System.out.println(Arrays.toString(array));

        int num1 = 1;
        int num2 = 2;
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("Swap method: num1: " + num1 + ", num2: " + num2);

        int[] array1 = {5, 2, 9, 7, 3};
        //swap 3rd and 5th
        int temp1 = array1[2]; //3rd element = 9
        array1[2] = array1[4]; //put 3 from 5th element into 3rd element
        array1[4] = temp1; //put temp 9 into 5th element
        System.out.println(Arrays.toString(array1));
    }

    @And("I convert a string {string} into int")
    public void iConvertAStringIntoInt(String arg) {
        int result = Integer.parseInt(arg);
        System.out.println(result);
    }

    @And("I solve coding challenges")
    public void iSolveCodingChallenges() {
        int num = 15;
        if (num%3==0 && num%5==0)
            System.out.println(num + " is div by both 3 and 5");
        else if (num%3==0)
            System.out.println(num + " is div by 3");
        else if (num%5==0)
            System.out.println(num + " is div by 5");
        else
            System.out.println(num + " is not div neither by 3 nor 5");
    }

    @And("I check the division")
    public void iCheckTheDivision() {
        int n = 11;
        if (n%3==0 && n%4==0)
            System.out.println(n + " is divisible by both 3 and 4");
        else if (n%3==0)
            System.out.println(n + " is divisible by 3");
        else if (n%4==0)
            System.out.println(n + " is divisible by 4");
        else
            System.out.println(n + "is not divisible by 3 nor 4");
    }

    @And("I am looking for the largest element in an array")
    public void iAmLookingForTheLargestElementInAnArray() {
        int[] array = {3, 12, 6, 21, 1, 4, 5};
        int theLargest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>theLargest){
                theLargest = array[i];
            }
        }
        System.out.println(theLargest);
    }

    @And("I am playing a FizzBuzz game")
    public void iAmPlayingAFizzBuzzGame() {
        int n = 20;
        for (int i = 1; i<= n; i++) {
            if (i%3==0 && i%5==0)
                System.out.print("FizzBuzz" + " ");
            else if (i%3==0)
                System.out.print("Fizz" + " ");
            else if (i%5==0)
                System.out.print("Buzz" + " ");
            else
                System.out.print(i + " ");
        }
    }

    @And("I reverse a string")
    public void iReverseAString() {
        String original = "WebDriver";
        System.out.println("Reverse a word: " + original);

        System.out.print("Reversed result: ");
        for (int i = original.length()-1; i >= 0; i--)
            System.out.print(original.charAt(i));

        //or variant 2
        System.out.println(); //чтобы не сливались строки между двумя вариантами

        String orig = "WebDriver";
        System.out.println("Reverse a word: " + orig);

        String res = "";

        for (int j = orig.length()-1; j>=0; j--) {
            res +=  orig.charAt(j);
        }
        System.out.println("Reversed result: " + res);
    }

    @And("I reverse words in a sentence")
    public void iReverseWordsInASentence() {
        String sentenseFirst = "I love Webdriver";
        String[] sentenseArray = sentenseFirst.split(" ");
        System.out.print("The result: ");
        for (int i = sentenseArray.length-1; i >=0; i--){
            System.out.print(sentenseArray[i] + " ");
        }

        //OR
        System.out.println(); //чтобы не сливались строки между двумя вариантами

        String sentenceSecond[] = "now I know it".split(" ");
        String result = "";
        for (int i = sentenceSecond.length-1; i >= 0; i--)
            result += sentenceSecond[i] + " ";

        System.out.print("The result: " + result);

    }

    @And("I sort an array")
    public void iSortAnArray() {
        int[] arr = {4, 3, 1 ,5, 8, 4};
        int temp;
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) { //the pointer (что мы сравниваем)
            for (int j = i + 1; j < arr.length; j++){    //for each move to compare (с чем мы сравниваем)
                if (arr[i] > arr[j]) {  //если предыдущий элемент больше следующего
                    temp = arr[i]; //делаем замену с помощью временной переменной
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }

    @And("I check if there are duplicates in an array")
    public void iCheckIfThereAreDuplicatesInAnArray() {
        int[] arr = {4, 3, 1 ,5, 8, 4};
        System.out.println("The original array: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i]==arr[j]) {
                    System.out.println("Found a double: " + arr[i]);
                }
            }
        }
    }

    @And("I determine if {string} is a palindrome")
    public void iDetermineIfIsAPalindrome(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        if (word.equals(result))
            System.out.println(word + " is a palindrome");
        else
            System.out.println(word + " is not a palindrome");
    }

    @And("I find the max number in array")
    public void iFindTheMaxNumberInArray() {
        int[] array = {4, 3, 1 ,5, 8, 4, 6, 5}; //дан array
        //Variant 1
        int max = Integer.MIN_VALUE; //то же самое, что и int max = 0 (обозначение), но только 0 не универсален на случай, если array состоит из отрицательных чисел

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        System.out.println("Max: " + max);

        //Variant 2  (с минимальными изменениями):
        int maxN = array[0]; ////по умолчанию ставим самый первый элемент(это может быть любой элемент, мы просто выбираем то, с чем будем сравнивать всё остальное) для сравнения с ним других

        for (int i = 0; i < array.length; i++) { ////i=1, так i=0 мы уже использовали для изначального firstMax, чтобы сравнивать с ним все другие элементы
            if (array[i] > max)
                max = array[i];
        }
        System.out.println("Max: " + max);

        //variant 3
        Arrays.sort(array); //сортуруем по возратанию имеющийся array
        max = array[array.length-1]; //обозначаем последний элемент как max
        System.out.println("Max: " + max);
    }

    @And("I find two max numbers in array")
    public void iFindTwoMaxNumbersInArray() {

        //Вариант 1:
        //Выбираем любой из этих array для проверки:
        //int[] array = {4, 3, 1 ,5, 8, 4}; //two max numbers = 8 and 5 (классический вариант с одной 8)
        //int[] array = {4, 3, 1 ,5, 8, 4, 8}; //two max numbers = 8 and 5 (доп вариант для проверки с двойной 8)
        //int[] array = {4, 3, 1 ,5, 8, 4, 8, 8}; //two max numbers = 8 and 5 (доп вариант для проверки с 3-мя 8)
        int[] array = {4, 3, 1 ,5, 8, 8, 6, 4, 8, 8}; ////two max numbers = 8 and 6 (доп вариант для проверки с 4-мя 8)
        //int[] array = {4, 3, 1 ,5, 8, 12, 9, 12}; //two max numbers = 12 and 9 (доп вариант для проверки с двойной 12)

        System.out.println(Arrays.toString(array)); //выводим изначальный array на экран
        Arrays.sort(array); //сортируем array в порядке возрастания

        int maxFirst = array[array.length - 1]; //берем последний элемент (i = 6-1) (самый большой) (он без вариантов max)
        int maxSecond = 0; //второй по счету max пока не известен, тк нам надо проверить, есть ли у нас дубли самого большого (первого) max

        //Если последние два и более чисел равны, то мы ждем число, которое будет им не равно, чтобы назначить его вторым максом
        //Итак, у нас уже есть array sorted. Проверяем на случай, если мы имеем два и более одинаковых max числа на конце :
        for (int i = array.length-2; i >= 0; i--) { //число на 1 левее
            if (maxFirst!=array[i]){ //если эти два числа не равны (int maxFirst = array[array.length - 1] - он нам уже известен выше, берем его как константу)
                maxSecond = array[i];
                break; //если не равны, получаем наш maxSecond и прерываем петлю. Если равны, то сравниваем со следующим числом на шаг левее от предыдущего (i--)
            }
        }
        System.out.println("Two max numbers are: " + maxFirst + " and " + maxSecond);


        //Вариант 2:
        //int[] numArray = {6, 2, 3, 5, 9};
        //int[] numArray = {6, 2, 3, 5, 9, 7};
        int[] numArray = {9, 6, 2, 3, 5, 9, 7};
        int firstMaxNum = numArray[0]; //по умолчанию ставим самый первый элемент(это может быть любой элемент, мы просто выбираем то, с чем будем сравнивать всё остальное) для сравнения с ним других
        int secondMaxNum = 0; //просто обозначаем с 0, тк с ним мы сравнивать ничего не будем
        System.out.println("The array is: " + Arrays.toString(numArray));

        for (int i = 0; i < numArray.length; i++) { //используем в данном случае i=0, чтобы сравнить его самого с собой для того, чтобы оно тоже имело возможность быть записанным в secondMaxNum
            if (numArray[i] > firstMaxNum) {
                secondMaxNum = firstMaxNum; //мы сохраняем предыдущее значение max перед тем, как присвоить ему новое значение
                firstMaxNum = numArray[i];
            } else if (numArray[i] > secondMaxNum && numArray[i]!= firstMaxNum) { //на тот случай, если в array firstMaxNum стоит раньше, чем secondMaxNum, соответственно мы не можем присвоить secondMaxNum в предыдущем условии
                secondMaxNum = numArray[i];
            }
        }
        System.out.println("Two max numbers are: " + firstMaxNum + " and " + secondMaxNum);
    }


    @And("I find the min number in array")
    public void iFindTheMinNumberInArray() {

        //Вариант 1
        int[] array = {4, 3, 1 ,5, 8, 4};
        int min = Integer.MAX_VALUE; //намеренно самое большое число, чтобы даже самый первый элемент имел возможность был меньше

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        System.out.println("Min: " + min);

        //Вариант 2:
        Arrays.sort(array); //сортуруем по возратанию имеющийся array
        min = array[0]; ////обозначаем первый элемент (с 0 индексом) как min
        System.out.println("Min: " + min);
    }

    @And("I find if any two elements of an array result in sum")
    public void iFindIfAnyTwoElementsOfAnArrayResultInSum() {



    }


    @And("I find if {int} is a prime number")
    public void iFindIfAIsAPrime(int number) {
        boolean prime = true;

        for (int i = 2; i < number; i++) { //for non-prime number. We are making sure that out number is not divided by any number between 2 and itself.
            if (number%i==0) {
                prime = false;
                break;
            }
        }
        if (prime)
            System.out.println(number + " is a prime number");
        else
            System.out.println(number + " is not a prime number");
    }

    @And("I find factorial of {int}")
    public void iFindFactorialOf(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("The factorial of " + number + " is " + factorial);


    }
}










