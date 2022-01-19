package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;
import pages.Animal;
import pages.Cat;
import pages.Dog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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


    @Given("I compare numbers {int} and {int}")
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

    @And("I repeat the word {string} {int} times with the help of loops")
    public void iRepeatTheWordTimesWithTheHelpOfLoops(String word, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(word);
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
        int[] array = {2, 3, 7, 9, 12, 22, 49, 14};
        for(int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                System.out.print(array[i] + " ");
        }
        System.out.println();
        //OR
        for (int el : array) {
            if (el%2==0) {
                System.out.print(el + " ");
            }
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

    @Given("I swap two variables")
    public void iSwapTwoVariables() {
        int[] array = {2, 4, 7, 9, 22};
        System.out.println("Original array: " + Arrays.toString(array));
        int a = array[0];
        int b = array[4];
        array[0] = b;
        array[4] = a;
        System.out.println("Result: " + Arrays.toString(array));

        int num1 = 1;
        int num2 = 2;
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("Swap method: num1: " + num1 + ", num2: " + num2);

        int[] array1 = {5, 2, 9, 7, 3};
        System.out.println("Original array1: " + Arrays.toString(array1));
        //swap 3rd and 5th
        int temp1 = array1[2]; //3rd element = 9
        array1[2] = array1[4]; //put 3 from 5th element into 3rd element
        array1[4] = temp1; //put temp 9 into 5th element
        System.out.println("Result1: " + Arrays.toString(array1));
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

    @And("I am playing a FizzBuzz game")
    public void iAmPlayingAFizzBuzzGame() {
        //Print integers 1 to N, but print “Fizz” if an integer is divisible by 3, “Buzz” if an integer is divisible by 5,
        //and “FizzBuzz” if an integer is divisible by both 3 and 5.
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

    @And("I am looking for the largest element in an array")
    public void iAmLookingForTheLargestElementInAnArray() {
        int[] array = {3, 12, 6, 21, 1, 4, 5};
        int theLargest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>theLargest){
                theLargest = array[i];
            }
        }
        System.out.println(theLargest);
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
        System.out.println("Initial sentense: " + sentenseFirst);
        String[] sentenseArray = sentenseFirst.split(" ");
        System.out.println("Number of words in the sentense: " + sentenseArray.length);
        System.out.print("The result: ");
        for (int i = sentenseArray.length-1; i >=0; i--){
            System.out.print(sentenseArray[i] + " ");
        }

        //OR
        System.out.println(); //чтобы не сливались строки между двумя вариантами
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
        System.out.println();
        //OR
        int[] array = {4, 3, 1 ,5, 8, 4};
        System.out.println("Initial array: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    @And("I check if there are duplicates in an array")
    public void iCheckIfThereAreDuplicatesInAnArray() {
        int[] array = {4, 3, 1 ,5, 8, 4};
        boolean doublePresence = false;
        System.out.println("The original array: " + Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++){
                if (array[i]==array[j]) {
                    System.out.println("Found a double: " + array[i]);
                    doublePresence = true;
                }
            }
        }
        if (!doublePresence) {
            System.out.println("No doubles in the array");
        }
    }

    @And("I determine if {string} is a palindrome")
    public void iDetermineIfIsAPalindrome(String word) {
        System.out.println("The word: " + word);
        String reversedWord = ""; //просто обозначаем как пустую
        for (int i = word.length()-1; i >= 0; i--) { //идем в обратную сторону
            reversedWord+=word.charAt(i); //добавляем к пустой строке по одной букве в обратном порядке, чтобы получилось reversed word
        }
        if (reversedWord.equals(word)) { //если перевернутое слово равно оригинальному, значит слово palindrome
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
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

        for (int i = 2; i < number; i++) { //for non-prime number. We are making sure that out number is not divided by any number between 1 (not included) and itself (not included).
            if (number%i==0) {
                prime = false;
                break;
            }
        }
        if (prime)
            System.out.println(number + " is a prime number");
        else
            System.out.println(number + " is not a prime number");


        //OR variant 2
        boolean notPrime = false; //not prime = false это prime (указываем по умолчанию)

        for (int i = 2; i < number; i++) {
            if (number%i==0) {
                System.out.println(number + " is not a prime number");
                notPrime = true;
                break;
            }
        }
        if (!notPrime) {
            System.out.println(number + " is a prime number");
        }

    }

    @And("I find factorial of {int}")
    public void iFindFactorialOf(int number) {
        int factorial = 1; // плюс, благодаря этой строчке, если у нас будет 0!, то он тоже будет равен 1 (по умолчанию)
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("The factorial of " + number + " is " + factorial);
    }

    @And("I find the max number in the file")
    public void iFindTheMaxNumberInTheFile() {
        File file = new File("/Users/alinaalinina/Downloads/dataset_91007.txt");

        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) { //обязательное условие по умолчанию
            System.out.println("No file found");
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>max) {
                max = list.get(i);
            }
        }
        System.out.println(max);
    }

    @And("I find the sum of numbers in the file")
    public void iFindTheSumOfNumbersInTheFile() {
        File file = new File("/Users/alinaalinina/Downloads/dataset_91033.txt");
        int sum = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
//                int n = scanner.nextInt();
//                sum+=n;
                //OR
                sum+= scanner.nextInt(); //суммируем каждый новый отсканированный элемент (объединили две верхние строки в одну)
            }
        } catch (FileNotFoundException e) { //обязательное условие по умолчанию
            System.out.println("No file found");
        }
        System.out.println(sum);
    }

    @And("I am playing a Fibonacci game")
    public void iAmPlayingAFibonacciGame() {
        //The Fibonacci series is a series of elements where, the previous two elements
        // are added to get the next element, starting with 0 and 1.
        int n = 10;
        int num1 = 0;
        int num2 = 1;

        for (int i = 0; i <= n; i++) {
            System.out.print(num1 + " ");
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
    }

    @And("I check whether {string} is a vowel or not")
    public void iCheckWhetherIsAVowelOrNot(String letterStr) {
        char letter= letterStr.charAt(0); //меняем формат буквы из String в char
        char[] array = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'}; //vowel letters
        boolean vowel = false;

        for (char el : array) { //берем каждый элемент array of vowels для сравнения с данной буквой
            if (letter==el) {
                System.out.println(letter + " is a vowel"); //если хотя бы с одним элементом array совпадает, значит vowel
                vowel = true;
                break; //тк хотя бы одного совпадения достаточно
            }
        }
        if(!vowel) {
            System.out.println(letter + " is not a vowel");
        }
    }

    @Given("I work with classes")
    public void iWorkWithClasses() {
        Animal animal = new Animal();
        animal.speak();

        System.out.println( );

        Animal cat = new Cat("Tom"); //=Cat значит методы будут вызываться оттуда
        cat.walk();
        cat.sleep();
        cat.speak();
        cat.eat("fish");

        Animal secondCat = new Cat(); //nameless also acceptable because we have a second constructor without parameter
        secondCat.walk();
        secondCat.sleep();
        secondCat.speak();
        secondCat.eat("fish");

        //cat.name = "Jerry"; //больше не можем использовать такую конструкцию
//        cat.setName("Jerry"); //should throw an error (we did it on purpose in setName() method in Cat.java)
        cat.setName("Frank"); //it is acceptable
        cat.sleep();

        //System.out.println(cat.name); //не можем напечатать name, тк оно private
        System.out.println("Cat's name is " + cat.getName()); //так можем (с помощью метода getName() в Cat.java файле) (it's read only)
        //тк мы выше указали имя Frank, то и выведется сюда оно
        System.out.println();

        Animal dog = new Dog("Rex");
        dog.eat("bones");
        dog.speak();
        dog.setName("Sharik");
        dog.sleep();
        dog.walk();

        Animal secondDog = new Dog("Max");
//        secondDog.say();

        System.out.println();

        List<Animal> animals = new ArrayList<>(); //создаем лист из созданных выше котов (объектов) - cat и secondCat
        animals.add(cat);
        animals.add(secondCat);
        printAnimalNames(animals); //вызываем доп метод
    }

    void printAnimalNames(List<Animal> animals) {
        System.out.println("All animal names: ");
        for (Animal animal : animals) {
            System.out.println(animal.getName());
            animal.sleep();
            animal.speak();
        }
    }
}










