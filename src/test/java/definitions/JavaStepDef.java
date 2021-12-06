package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.DeleteSession;

import static org.assertj.core.api.Assertions.*;

import java.security.Key;
import java.sql.SQLOutput;
import java.util.*;

import static support.TestContext.getDriver;

public class JavaStepDef {


    @Given("I hello world")
    public void iHelloWorld() {
        System.out.println("Hello world");
    }

    @And("I say {string}")
    public void iSay(String text) {
        System.out.println(text);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println(str1 + ", " + str2);
        System.out.println((str1 + ", " + str2).toUpperCase(Locale.ROOT));
        System.out.println((str1 + str2).length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains(str2));
    }


    @When("I perform actions with numbers {int} and {int}")
    public void iPerformActionsWithNumbersAnd(int int1, int int2) {
        System.out.println(int2 / int1);
        float f = 2.5F;
        System.out.println(int2 / f);

    }

    @And("I compute the sum, difference, quotient, and product of {int} and {int}")
    public void iComputeTheSumDifferenceQuotientAndProductOfAnd(int num1, int num2) {
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;
        System.out.println("The sum is = " + sum + "; Difference is = " + difference + "; The quotient is = " + quotient + "; The product is = " + product);

    }


    @And("My least favorite color is {string}")
    public void myNotFavoriteColorIs(String v1) {
        String notFavoriteColor = "Silver";
        boolean b = notFavoriteColor.equals(v1);
        System.out.println(b);
    }

    @And("I compare {string} and {string} strings")
    public void iCompareAndStrings(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.println("String " + s1 + " and " + s2 + " are equal");
        } else {
            System.out.println("They are not equal");
        }
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equalsIgnoreCase("google")) {
            System.out.println("https://google.com");
        }
        if (site.equalsIgnoreCase("yahoo")) {
            System.out.println("https://yahoo.com");
        }
        if (site.equalsIgnoreCase("sample")) {
            System.out.println("https://skryabin.com/webdriver/html/sample.html");
        } else {
            System.out.println("Come back later");
        }
    }

    @And("I print URL for {string} using switch")
    public void iPrintURLForUsingSwitch(String url) {
        switch (url.toLowerCase()) {
            case "google":
                System.out.println("google.com");
                break;
            case "yahoo":
                System.out.println("yahoo.com");
                break;

        }
    }

    @And("I work with loops")
    public void iWorkWithLoops() {
        for (int i = 0; i <= 10; i = i + 1) {
            System.out.println(1);
        }
    }

    @And("I work with grocery list array")
    public void iWorkWithGroceryListArray() {
        String[] groceryList = {
                "eggs", "tomatoes", "asparagus", "oil", "lettuce", "fish", "apples"};
        for (String element : groceryList)
//        System.out.println(element);
            System.out.println(groceryList[1]);
    }

    @And("I work with int array list")
    public void iWorkWithIntArrayList() {
        int[] arr = {12, 21, 34, 41, 15, 64, 72};
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
            case "google" -> getDriver().get("https://google.com");
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
            default -> System.out.println("Unsupported page: " + page);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
        System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String res) throws InterruptedException {
        if (res.equalsIgnoreCase("phone")) {
            getDriver().manage().window().setSize(new Dimension(400, 768));
            Thread.sleep(3000);
        } else if (res.equalsIgnoreCase("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
            Thread.sleep(3000);

        }
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        // filling out name fields
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Ivan");
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys("Ivanov");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Ivanovich");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        //filling out username
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("ivan69");
        // filling out passwords
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password");
        // filling out email
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        // checking privacy policy
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();


    }

    @When("I submit a form")
    public void iSubmitAForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @And("I return to the fill out form")
    public void iReturnToTheFillOutForm() {
        getDriver().findElement(By.xpath("//button[@id='return']")).click();
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("bugzbunny");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
    }


    @Given("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num > 0) {
            System.out.println("Number " + num + " is positive");
        } else if (num < 0) {
            System.out.println("Number " + num + " is negative");
        } else
            System.out.println("Number is zero");
    }

    @And("I print {int} day of the week")
    public void iPrintDayOfTheWeek(int day) {
        if (day == 1) {
            System.out.println("Monday");
        } else if (day == 2) {
            System.out.println("Tuesday");
        } else if (day == 3) {
            System.out.println("Wednesday");
        } else if (day == 4) {
            System.out.println("Thursday");
        } else if (day == 5) {
            System.out.println("Friday");
        } else if (day == 6) {
            System.out.println("Saturday");
        } else if (day == 7) {
            System.out.println("Sunday");
        } else System.out.println("This day is not existing");
    }

    @Then("I verify that submitted fields saved correctly")
    public void iVerifyThatSubmittedFieldsSavedCorrectly() {
        //verifying Name field
        getDriver().findElement(By.xpath("//b[@name='name']")).getText().equalsIgnoreCase("Ivan Ivanov Ivanovich");
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo("Ivan");
        // getDriver().findElement(By.xpath("//b[@name='firstName']")).getText().equalsIgnoreCase("Ivan");
        getDriver().findElement(By.xpath("//b[@name='middleName']")).getText().equalsIgnoreCase("Ivanov");
        getDriver().findElement(By.xpath("//b[@name='lastName']")).getText().equalsIgnoreCase("Ivanovich");
        //verifying Username
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).contains("69");

    }

    @And("I print {int} day of the weeks")
    public void iPrintDayOfTheWeeks(int day) {
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("something else");
        }
    }

//    @Given("I print numbers from zero to {int}")
//    public void iPrintNumbersFromZeroTo(int num) {
//        if (num > 0) {
//            for (int i = 0; i <= num; i++) {
//                System.out.println(i);
//            }
//        } else {
//            for (int i = 0; i >= num; i--) {
//                System.out.println(i);
//            }
//        }
//    }
//
//    @And("Function that prints all integer array")
//    public void functionThatPrintsAllIntegerArray() {
//        int[] num = {12, 34, 5, 1, 3, 4, 5, 6, 7, 8, 9, 0};
//        //    Simple method
//        System.out.println(Arrays.toString(num));
//        // Read only  example
//        for (int ar : num) {
//            System.out.println(ar);
//        }
//    }
//
//
//    @And("Lists")
//    public void lists() {
//        List<String> daysList = new ArrayList<>();
//        daysList.add("Sunday");
//        daysList.add("Monday");
//        daysList.add("Tuesday");
//        daysList.add("Wednesday");
//        daysList.add("Thursday");
//        daysList.add("Friday");
//        daysList.add("Saturday");
//        System.out.println(daysList);
//
//        List<Integer> numsList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 655, 443, 223));
//        System.out.println(numsList);
//
//    }
//
//    @And("A function that prints all even numbers from integer array")
//    public void aFunctionThatPrintsAllEvenNumbersFromIntegerArray() {
//
//// first solution
//        int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 32, 122, 50, 655, 443, 223};
//        for (int i = 0; i < numArray.length; i++)
//            if (numArray[i] % 2 == 0) {
//                System.out.println(numArray[i]);
//            }
//        // second solution
////        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
////        for (int j : arr)
////            if (j % 2 == 0) {
////                System.out.println(j);
////            }
//    }
//
//    @And("A function that checks if array is empty")
//    public void aFunctionThatChecksIfArrayIsEmpty() {
//        int[] arr = {1, 2};
//
//        if (arr.length == 0) {
//            System.out.println("Array is empty");
//
//        } else {
//            System.out.println("Array is not empty");
//        }
//    }
//
//
//    @And("A function that checks if array contains int {int}")
//    public void aFunctionThatChecksIfArrayContains(int el) {
//        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
////        List<Integer> intList = new ArrayList(List.of(intArray));
////        System.out.println(intList.contains(el));
//        System.out.println(" Array contains " + el + " is " + ArrayUtils.contains((intArray), el));
//
//    }
//
//    @And("A function that checks if array contains string {string}")
//    public void aFunctionThatChecksIfArrayContains(String day) {
//        String[] daysOfWeeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        System.out.println("Array contains " + day + " is " + ArrayUtils.contains(daysOfWeeks, day));
//    }

    @Given("Prints all numbers from {int} up to {int}")
    public void printsAllNumbersFromUpTo(int j, int n) {
        for (int i = j; i < n + 1; i++) {
            System.out.println(i);
        }
    }

    @And("Prints also negative numbers from {int}")
    public void printsAlsoNegativeNumbersFrom(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = 0; i > n - 1; i--) {
                System.out.println(i);
            }
        }
    }

    @And("Print all integer array")
    public void printAllIntegerArray() {
        int[] arr = {1, 2, 3, 5, 6, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
    }

    @And("Print all even numbers from integer array")
    public void printAllEvenNumbersFromIntegerArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 76, 77, 75, 90};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i]+ " ");
            }
        }
    }

    @And("Check if array is empty")
    public void checkIfArrayIsEmpty() {
        int[] arr = {1};

        if (arr.length == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty");
        }
    }


    @And("Check if array contains another element example")
    public void checkIfArrayContainsAnotherElementExample() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        // System.out.println("Array contains " + n +" is "+ ArrayUtils.contains((arr),n));
        // 2nd solution
        int target = 7;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }


    @Given("Program that prints the sum of the numbers {int} to {int}")
    public void programThatPrintsTheSumOfTheNumbersToN(int arg0, int n1) {
        int n = 5;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        System.out.println("sum = " + sum);
    }

    @And("Modify the program such that only multiplies of three or five are considered in the sum")
    public void modifyTheProgramSuchThatOnlyMultipliesOfThreeOrFiveAreConsideredInTheSum() {
        int n = 17;
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            if (j % 3 == 0 || j % 5 == 0)
                sum = sum + j;
        }
        System.out.println("sum = " + sum);

    }

    @And("Computing sum and computing product")
    public void computingSumAndComputingProduct() {

        int n = 7;
        String option = "product";
        int sum = 0;
        if (option.equals("sum")) {
            for (int j = 1; j <= n; j++) {

                sum = sum + j;
            }
            System.out.println("sum = " + sum);
        } else {
            int product = 1;
            for (int j = 1; j <= n; j++) {
                product = product * j;
            }
            System.out.println("Product = " + product);
        }
    }

    @And("Sort odd numbers in asc order but even numbers must be on their places")
    public void sortOddNumbersInAscOrderButEvenNumbersMustBeOnTheirPlaces() {
//        int[] arr = { 5,3,3,8,4,1};
//        sortArr(arr);
//    }
//
//    private void sortArr(int[] arr) {
//        int idxMin = 0;
//        int min = arr[idxMin];
//        for (int i = 1; i< arr.length; i++){
//            if (arr[i]< min) {
//               min = arr[i];
//               idxMin = i;
//            }
//        }
//        System.out.println("Min = "+ min);
//        System.out.println("ixdMin = "+ idxMin);
//        int temp = arr[0];
//    }

        int[] arr = {5, 3, 2, 8, 4, 1, -10, 9, 0, -7};
        System.out.println(Arrays.toString(arr));

//sort odd numbers only
        for (int j = 0; j < arr.length - 1; j++) { // continue
            if (arr[j] % 2 == 0) {
                continue;
            }
            int idxMin = j;
            for (int i = j + 1; i < arr.length; i++) {
                if ((arr[i] < arr[idxMin]) && (arr[i] % 2 != 0)) {
                    idxMin = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[idxMin];
            arr[idxMin] = temp;

            System.out.println(Arrays.toString(arr));
        }
// break
    }

    @And("prints multiplication table of numbers")
    public void printsMultiplicationTableOfNumbers() {
        int n = 12;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                System.out.print(x * y + "\t");
            }
            System.out.println();
        }
    }

    @And("combines two array by alternating taking elements")
    public void combinesTwoArrayByAlternatingTakingElements() {
        int[] arr1 = {0, 5, 8, 9, 1};
        int[] arr2 = {1, 2, 3};

        int len = arr1.length + arr2.length;
        int[] res = new int[len];
        int minLen = arr1.length < arr2.length ? arr1.length : arr2.length;


        for (int k = 0; k < minLen * 2; k = k + 2) {
            res[k] = arr1[k / 2];
            res[k + 1] = arr2[k / 2]; // k = 2; 2/2 -> 1
        }
        // res = [0, 1, 5, 2, 8, 3, _, _]
        // rest of arr1: [9,1]
        // min_len = 3
        // [0,5,8,   9,1]
        for (int idx = minLen; idx < arr1.length; idx++) {
            // idx = 3
            // idx 3 -> idx - min_len => 0
            int res_idx = minLen * 2 + idx - minLen;
            res[res_idx] = arr1[idx];
        }
        for (int idx = minLen; idx < arr2.length; idx++) {
            // idx = 3
            // idx 3 -> idx - min_len => 0
            int res_idx = minLen * 2 + idx - minLen;
            res[res_idx] = arr2[idx];
        }

        System.out.println(Arrays.toString(res));
    }

    @Given("print array")
    public void printArray() {
//        int[] arr = { 1,2,3,4,5,6,7};
//        for (int j : arr) {
//            System.out.println(j);
//        }
//        String[] s = new String[3];
//        s[0] = "Hi";
//        s[1] = "Bye";
//        s[2] = "Java";
////        for (int i = 0; i< s.length; i++ ){
////            System.out.println(s[i]);
////        }
//        for (String string : s){
//            System.out.println(string);
//        }
//        int[] num2 = {1,2,3};
//        int sum = 0;
//        for (int x : num2){
//            sum = sum +x;
//        }
//        System.out.println(sum);

        for (int i = 0; i <= 15; i++) {
            if (i % 2 == 0) {
                int j = i * 10;
                System.out.println("this is even number " + i);
                continue;

            }
            System.out.println("this is odd number " + i);
        }
    }

    @And("sorting asc using while")
    public void sorting() {
        int[] arr = {43, 2, 1};
        System.out.println(Arrays.toString(arr));

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }


    @And("sorting desc using while")
    public void sortingAsc() {
        int[] arr = {-1, 44, 2, 1, 54, 23, 45, 56, 67, 53, 32, 44, 87, 49, 61, 37};
        System.out.println(Arrays.toString(arr));
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] < arr[i +1 ]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    @And("sorting desc")
    public void sortingDesc() {
        int[] arr = {43, 2, 1, 54, 23, 45, 56, 67, 53, 32, 44, 87, 49, 61, 37};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] < arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    @And("sorting desc odd numbers")
    public void sortingDescOddNumbers() {
        int[] arr = {43, 34, 33, 54, 23, 45, 56, 67, 53, 32, 44, 87, 49, 61, 37};
        System.out.println(Arrays.toString(arr));

//        sort odd numbers only
        for (int j = 0; j < arr.length - 1; j++) { // continue
            if (arr[j] % 2 == 0) {
                continue;
            }
            int idxMin = j;
            for (int i = j + 1; i < arr.length; i++) {
                if ((arr[i] < arr[idxMin]) && (arr[i] % 2 != 0)) {
                    idxMin = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[idxMin];
            arr[idxMin] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    @And("sorting desc odd numbers mk")
    public void sortingDescOddNumbersMk() {

    }

    @And("prints multiplication table of numbers practice")
    public void printsMultiplicationTableOfNumbersPractice() {
        int n = 12;
        for (int y = 1; y<= n; y++){
            for (int x = 1; x<= n;x++ ){
                System.out.print(x * y +"\t");
            }
                System.out.println();
        }
    }

    @And("combines two array by alternating taking elements practice")
    public void combinesTwoArrayByAlternatingTakingElementsPractice() {
    int[] arr1 = {0,5,8};
    int[] arr2 = {1,2,3};

    int len = arr1.length + arr2.length;
    int[] res = new int[len];

    int i= 0;
    int j = 0;

    for (int k= 0; k<len; k= k+2){
        res[k] = arr1[i++];
        res[k+1] = arr2[j++];

    }
       System.out.println(Arrays.toString(res));
    }

    @And("combines two array by alternating taking elements practice Diff length arr")
    public void combinesTwoArrayByAlternatingTakingElementsPracticeDiffLengthArr() {
        int [] arr1 = {0,5,8,2,1,4,5};
        int [] arr2 = {1,2,3,4,1};

        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] result = new int[len1+len2];
        int i = 0;
        int j = 0;
        int k = 0;

        while((i<len1) && (j<len2)) {
            result[k++]= arr1[i++];
            result[k++]= arr2[j++];
        }
        while (i<len1) result[k++] = arr1[i++];
        while (j<len2) result[k++] = arr2[j++];
        System.out.println(Arrays.toString(result));
    }

    @Given("work with lists")
    public void workWithLists() {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
//        System.out.println(numList);

        List<String> user = new ArrayList<>();
        user.add("admin");
        user.add("editor");
        user.add("writer");
        String admin = user.get(0);
        System.out.println(admin);

    }



    @And("work with sets")
    public void workWithSets() {
        List<String>  sList = new ArrayList<>();
        sList.add("a");
        sList.add("b");
        sList.add("b");
        sList.add("c");
        sList.add("c");
        sList.add("d");
        System.out.println(sList);


        Set<String> set = new HashSet<>(sList);
        System.out.println(set);

    }

    @And("work with Map")
    public void workWithMap() {
        Map<String, String> user = new HashMap<>();
        user.put("user", "milad");
        user.put("email", "test@test.com");
        String milad = user.get("user");
        System.out.println(milad);
    }

    @Given("a function that swaps two array elements")
    public void aFunctionThatSwapsTwoArrayElements() {
        int[] arr = {5,2,9,7,3};
        System.out.println("Array before the swap " + Arrays.toString(arr));
        for (int k = 0; k < arr.length; k++) {
            toSwap(arr, 2, 4);
        }
//        int temp = arr[2];
//        arr[2] = arr[4];
//        arr[4] = temp;
        System.out.println("Array After the swap " + Arrays.toString(arr));
    }
     public void toSwap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//         int temp = i;
//         i = j;
//         j = temp;
    }
    @And("is the number divisible by {int} and {int}")
    public void isTheNumberDivisibleByAnd(int arg0, int arg1) {
        int num = 444;
        if (num%3 == 0 && num%4 ==0){
            System.out.println("Number "+ num + " is divisible by 3 and 4 ");
        } else if (num%3 == 0){
            System.out.println("Number "+ num + " is divisible by 3");
        }else if (num%4 == 0) {
            System.out.println("Number "+ num + " is divisible by 4");
        } else {
            System.out.println("Number "+ num + " is not divisible by 3 or 4 ");
        }

    }

    @And("a function to find the largest element in an array")
    public void aFunctionToFindTheLargestElementInAnArray() {
        int[] arr = {11,2,3,1,5,10,4,6};

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i-1]){
               int temp = arr[i];
               arr[i] = arr[i-1];
               arr[i-1] = temp;
            }
        }
        int largest = arr[arr.length-1];
        System.out.println(largest);

    }

    @And("a function that reverses words in a sentence")
    public void aFunctionThatReversesWordsInASentence() {
        String s[] = "you shall not pass".split(" ");
        String ans = "";
        for (int i = s.length - 1; i >= 0; i--) {
            ans += s[i] + " ";
        }
        System.out.println("Reversed String: " + ans);
    }



    void printReversed(String str){
        System.out.println("Print Reversed " + str);
        for (int i = str.length() - 1; i >= 0 ; i--){
            System.out.print(str.charAt(i));
        }
    }


    String getReversed(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
                return reversed;
    }



    @And("FizzBuzz challenge")
    public void fizzbuzzChallenge() {
    fizzBuzzTwo(20);
    }


    void fizzBuzzTwo(int num){
    for (int i = 1; i <= num; i++){
        if (i % 15 == 0){
            System.out.print("FizzBuzz ");
        }else if (i % 3 ==0){
            System.out.print("Fizz ");
        }else if (i % 5 ==0){
            System.out.print("Buzz ");
        } else {
            System.out.print( i + " ");
        }
    }
    }

    @And("combines two array by alternating taking elements Lists")
    public void combinesTwoArrayByAlternatingTakingElementsLists() {
        List<Integer> list1 = List.of(1,3,5,2,2,4,4,5);
        List<Integer> list2 = List.of(2,4,6,7,8);
        List<Integer> result = new ArrayList<>();

        ListIterator<Integer> itr1 = list1.listIterator();
        ListIterator<Integer> itr2 = list2.listIterator();

        while (itr1.hasNext() && itr2.hasNext()){
            result.add(itr1.next());
            result.add(itr2.next());
        }
        while (itr1.hasNext()) result.add(itr1.next());
        while (itr2.hasNext()) result.add(itr2.next());
        System.out.println(result);


    }

    void revString (String str){
        for (int i = str.length() - 1; i>= 0; i--){
            System.out.print(str.charAt(i));
        }
    }

}

