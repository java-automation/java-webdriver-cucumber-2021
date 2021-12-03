package definitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class JavaStepDefs {

    @Given("I am dividing {int} by {double}")
    public void division(int i, double d) {
        if ( d % 1 == 0 )
            System.out.println( "RESULT of dividing " + i + " by " + (int) d + " is " + i/(int) d );
        else
            System.out.println( "RESULT of dividing " + i +  " by " + d  + " is " + i/d );
    }

    @Given("I print URL for page {string}")
    public void iPrintURLForPage(String page) {
        if (page.equals("google")) {
            System.out.println("https://www.google.com/");
        } else if(page.equals("yahoo")) {
            System.out.println("https://www.yahoo.com/");
        } else {
            System.out.println("Unsupported page: " + page);
        }
    }

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "google" -> getDriver().get("https://www.google.com/");
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
            default -> System.out.println("Unsupported page: " + page);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println("Title: " + getDriver().getTitle());
        System.out.println("Current title: " + getDriver().getCurrentUrl());
        System.out.println("Window handle: " + getDriver().getWindowHandle());
        System.out.println("Page source:\n" + getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I wait")
    public void iWait() throws InterruptedException {
        Thread.sleep(3000);
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String device_type) {
        int width, height;
        switch (device_type) {
            case "phone" -> {
                width = 400;
                height = 768;
            }
            case "desktop" -> {
                width = 1024;
                height = 768;
            }
            default -> throw new Error("No such device type as " + device_type);
        }
        getDriver().manage().window().setSize(new Dimension(width,height));
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("Dan Beck");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("dan@example.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("dan_b");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @When("I fill out optional fields")
    public void iFillOutOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("2353456");
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']//option[@value='Austria']")).click();
        getDriver().findElement(By.xpath("//input[@value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@name='address']")).sendKeys("123 Sweet street, Los Angeles, CA");
        getDriver().findElement(By.xpath("//select[@name='carMake']//option[@value='Ford']")).click();
        getDriver().findElement(By.xpath("//select[@name='carMake']//option[@value='Toyota']")).click();
        getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().findElement(By.xpath("//input[@name='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']//option[@value='2']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']//option[@value='2000']")).click();
        getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='10']")).click();
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify that submitted fields saved correctly")
    public void iVerifyThatSubmittedFieldsSavedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("Dan Beck");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isEqualTo("[entered]");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("dan@example.com");
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        try {
            getDriver().findElement(By.xpath("//input[@name='email']")).clear();
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("a.b@c.d.com");
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).clear();
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("a.b@cd.com");
            iWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I print {string} day of week")
    public void iPrintDayOfWeek(String ordinal_number) {
        int day_num = Integer.parseInt(ordinal_number);
        switch (day_num) {
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            case 7 -> System.out.println("Saturday");
            default -> throw new Error("Invalid entry: " + day_num + ". There are only 7 days in a week!");
        }
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String number) {
        long num = Long.parseLong(number);
        if (num < 0) {
            System.out.println("Number is negative");
        } else if (num > 0) {
            System.out.println("Number is positive");
        } else {
            throw new Error("Zero is neither a positive number nor a negative number.");
        }
    }

    @Then("print all numbers from zero up to positive {int}")
    public void printsAllNumbersFromZeroToPositiveN(int n) {
        if ( n<0 ) throw new Error("Positive number expected. Actual: " + n);
        IntStream.range(0, n+1).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    @Then("print all numbers from zero to {int}")
    public void printsAllNumbersFromZeroToN(int n) {
        int sign = (n == 0) ? 0 : n / Math.abs(n);
        for (int i = 0; i <= Math.abs(n); i++) {
            System.out.print( sign * i + " ");
        }
        System.out.println("\b");
    }

    @ParameterType("[\\{]*([^\"}]*)[\\}]*")
    public int[] int_array(String str_array) {
        if (str_array.isEmpty()) return new int[0];
        return Arrays.stream(str_array.split(",")).map(String::strip).mapToInt(Integer::parseInt).toArray();
    }

    @ParameterType("[\\{]*(\"[^}]*\")[\\}]*")
    public String[] string_array(String str_array) {
        if (str_array.isEmpty()) return new String[] {};
        return str_array.replace("\"","").split(",");
    }

    @Then("print all integer array {int_array}")
    public void printAllIntegerArray(int[] arr) {
        System.out.print("{");
        for (int i : arr) System.out.print(i + ",");
        System.out.println("\b}");
    }

    @Then("all even numbers from integer array {int_array}")
    public void allEvenNumbersFromIntegerArray(int[] arr) {
        Arrays.stream(arr).filter(num -> num % 2 == 0).forEach(i -> System.out.print(i + " "));
        System.out.println("\b");
    }

    @Then("check if array {int_array} is empty")
    public void checksIfArrayIsEmpty(int[] arr) {
        System.out.println("RESULT: " + (arr.length == 0));
    }

    @Then("check if array {int_array} contains element {int}")
    public void checksIfArrayContainsElementOtherThan(int[] arr, int search_elem) {
        System.out.print("RESULT: ");
        System.out.println(Arrays.stream(arr).anyMatch(num -> num == search_elem));
    }

    @Then("check if array {int_array} contains element other than present in {int_array}")
    public void checksIfArrayContainsElementOtherThan(int[] arr, int[] allowed_values_arr) {
        IntStream intstream = Arrays.stream(allowed_values_arr);
        System.out.print("RESULT: ");
        System.out.println(Arrays.stream(arr).filter(num -> intstream.anyMatch(x -> x != num)).findFirst().isEmpty());
    }

    public static int[] joinPrimitiveIntegerArraysAlternating(int[] arr1, int[] arr2) {
        int[] result_arr = new int[arr1.length+arr2.length];
        int min_length = Math.min(arr1.length,arr2.length);
        for (int i=0; i<min_length*2; i=i+2) {
            result_arr[i] = arr1[i/2];
            result_arr[i+1]=arr2[i/2];
        }
        for (int k=min_length; k<arr1.length; k++) {
            result_arr[min_length*2+k-min_length] = arr1[k];
        }
        for (int n=min_length; n<arr2.length; n++) {
            result_arr[min_length*2+n-min_length] = arr2[n];
        }
        return result_arr;
    }

    public static List<Integer> joinPrimitiveIntegerArraysToListAlternating(int[] arr1, int[] arr2) {
        List<Integer> l1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        return joinListsAlternating(l1,l2);
    }

    public static <T> List<T> joinListsAlternating(List<T> l1, List<T> l2) {
        List<T> result_list = new LinkedList<>();
        int i=0;
        int l1_size = l1.size();
        int j=0;
        int l2_size = l2.size();
        while ((i<l1_size) || (j<l2_size)) {
            if (i<l1_size) {result_list.add(l1.get(i)); i++;}
            if (j<l2_size) {result_list.add(l2.get(j)); j++;}
        }
        return result_list;
    }

    @Then("array {int_array} and array {int_array} are joined together alternating into {int_array}")
    public void arraysAreJoinedTogether(int[] arr1, int[] arr2, int[] result) {
        assertThat(joinPrimitiveIntegerArraysAlternating(arr1,arr2)).isEqualTo(result);
    }

    @Then("list {int_array} and list {int_array} are joined together alternating into {int_array}")
    public void listsAreJoinedTogether(int[] arr1, int[] arr2, int[] result) {
        List<Integer> expected_result = Arrays.stream(result).boxed().collect(Collectors.toList());
        assertThat(joinPrimitiveIntegerArraysToListAlternating(arr1,arr2)).isEqualTo(expected_result);
    }

    @Then("array {int_array} and array {string_array} are joined together alternating into {string_array}")
    public void arrayAndArrayAreJoinedTogetherAlternatingInto(int[] arr1, String[] s_arr2, String[] result) {
        List<String> list_arr1 = Arrays.stream(arr1).mapToObj(i -> String.valueOf(i)).toList();
        assertThat(joinListsAlternating(list_arr1, Arrays.asList(s_arr2))).isEqualTo(Arrays.asList(result));
    }

    @Then("do FizzBuzz printing by method 1 for number {int}")
    public void fizzBuzz1(int num) {
        long start = System.nanoTime();
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        if (num >= 1) {
            System.out.println("\b");
        }
        long stop = System.nanoTime();
        System.out.println("Elapsed time: " + (stop - start));
    }

    @Then("do FizzBuzz printing by method 2 for number {int}")
    public void fizzBuzz2(int num) {
        long start = System.nanoTime();
        for (int i = 1; i <= num; i++) {
            if (i % 5 != 0) {
                if (i % 3 != 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("Fizz ");
                }
            } else if (i % 3 != 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print("FizzBuzz ");
            }
        }
        if (num >= 1) {
            System.out.println("\b");
        }
        long stop = System.nanoTime();
        System.out.println("Elapsed time: " + (stop - start));
    }

    @Then("do FizzBuzz printing by method 3 for number {int}")
    public void fizzBuzz3(int num) {
        long start = System.nanoTime();
        String s = "";
        for (int i = 1; i <= num; i++) {
            s = "";
            if (i % 3 == 0) s += "Fizz";
            if (i % 5 == 0) s += "Buzz";
            if (s.isEmpty()) s += i;
            System.out.print(s + " ");
        }
        System.out.println("\b");
        long stop = System.nanoTime();
        System.out.println("Elapsed time: " + (stop - start));
    }

    @Then("do FizzBuzz printing by method 4 for number {int}")
    public void fizzBuzz4(int num) {
        long start = System.nanoTime();
        int n = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0) {
                System.out.print("Fizz");
                n = 1;
            }
            if (i % 5 == 0) {
                System.out.print("Buzz");
                n = 1;
            }
            if (n == 0) System.out.print(i);
            System.out.print(" ");
            n = 0;
        }
        System.out.println("\b");
        long stop = System.nanoTime();
        System.out.println("Elapsed time: " + (stop - start));
    }

    private void swapInArray(int[] arr, int idx1, int idx2) {
        if (idx1 == idx2) return;
        if (idx1 < 0 || idx1 >= arr.length || idx2 < 0 || idx2 >= arr.length) {
            throw new Error("Index(es) is outside of the arrays boundaries");
        }
        arr[idx1] = arr[idx1] + arr[idx2];
        arr[idx2] = arr[idx1] - arr[idx2];
        arr[idx1] = arr[idx1] - arr[idx2];
    }

    @Then("reverse string {string}")
    public String reverseUnicodeString(String str) {
        System.out.println("Input string: " + str + " with length in Unicode code units: " + str.length());
        System.out.println("Input string escaped for printing only: " + StringEscapeUtils.escapeJava(str));
        int[] int_array = str.codePoints().toArray();
        int len = int_array.length;
        // Java internal String representations uses UTF16 encoding [16 is the size of a code unit in bits].
        // A code point is the value that a Unicode (UCS) character is mapped to in the Unicode standard.
        // In UTF16 (Unicode Transformation Format) code points are encoded with 1 or 2 code units.
        // For example, the flat note symbol ♭ has a code point of U+1D160 and would be encoded using
        // the combination of two 16-bit code units U+D834 and U+DD60 in UTF16 (high-low surrogate pair).
        System.out.println("Input string length in Unicode code points: " + len);
        for (int i = 0; i < len/2; i++) {
            swapInArray(int_array,i,len-1-i);
        }
        String reversed_str = new String(int_array, 0, len);
        System.out.println("Reversed string: " + reversed_str +
                           " with length in Unicode code units: " + reversed_str.length());
        // StringEscapeUtils.escapeJava method deals correctly with quotes and control-chars,
        // so a tab becomes the characters '\\' and 't'.
        System.out.println("Reversed escaped string for printing only: " + StringEscapeUtils.escapeJava(reversed_str));
        return reversed_str;
    }

    @Then("reverse string {string} via StringBuffer")
    public String reverseString2(String str) {
        String reversed_str = new StringBuffer(str).reverse().toString();
        System.out.println("Reversed string: " + reversed_str);
        return reversed_str;
    }

    @Then("reverse string {string} unescaped")
    public String reverseStringUnescaped(String str) {
        // For example, StringEscapeUtils.unescapeJava will turn a sequence of '\' and 'n' into a newline character,
        // unless the '\' is preceded by another '\'
        String unescaped_str = StringEscapeUtils.unescapeJava(str);
        String reversed_str = reverseUnicodeString(unescaped_str);
        System.out.println("Reversed string escaped for printing only: " + StringEscapeUtils.escapeJava(reversed_str));
        return reversed_str;
    }

    @Then("reverse common string {string}")
    public String reverseCommonString(String str) {
        System.out.println("Input string: " + str + " with length in Unicode code units: " + str.length());
        System.out.println("Input string escaped for printing only: " + StringEscapeUtils.escapeJava(str));
        char[] char_array = str.toCharArray();
        int len = char_array.length;
        System.out.println("Input string: " + str + " with length in chars (units of 2 bytes): " + str.length());
        char temp;
        for (int i = 0; i < len / 2; i++) {
            temp = char_array[i];
            char_array[i] = char_array[len-1-i];
            char_array[len-1-i] = temp;
        }
        String reversed_str = new String(char_array);
        System.out.println("Reversed string: " + reversed_str +
                           " with length in Unicode code units: " + reversed_str.length() );
        System.out.println("Reversed escaped string for printing only: " + StringEscapeUtils.escapeJava(reversed_str));
        return reversed_str;
    }

    @Then("reverse words in sentence {string}")
    public void reverseWordsInSentence(String str) {
        String[] str_array = StringEscapeUtils.unescapeJava(str).split("\\W+");
        int len = str_array.length;
        for (int i=0; i<len/2; i++) {
            str_array[len-1-i] = str_array[i] + ( str_array[i] = str_array[len-1-i] ).substring(0,0);
        }
        // alternatively via stream
        // String[] revered_words = (String[]) IntStream.range(0,len).mapToObj(i -> str_array[len-1-i]).toArray());
        System.out.println(String.join(" ", str_array));
    }

    @Then("swaps two elements of array {int_array} in positions {int} and {int}")
    public void swapsTwoElementsOfArrayRdAndTh(int[] arr, int pos1, int pos2) {
        if (pos1 < 1 || pos1 > arr.length || pos2 < 1 || pos2 > arr.length ) {
            System.out.println("Swap is not applicable for passed positions " + pos1 + " and " + pos2);
        } else {
            swapInArray(arr, pos1 - 1, pos2 - 1);
            System.out.println("Resulting array: " + Arrays.toString(arr));
        }
    }

    @Then("largest element in an array {int_array}")
    public void largestElementInAnArray(int[] arr) {
        if (arr==null || arr.length==0) {
            System.out.println("No max value in an empty array");
            return;
        }
        int max=Integer.MIN_VALUE;
        for (int el : arr) {
            if (max < el) max = el;
        }
        System.out.println("Max value: " + max);
    }
}
