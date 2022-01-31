package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.text.io.StringSubstitutorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.Animal;
import pages.Cat;
import pages.Dog;
import pages.Parrot;
import pages.Kangaroo;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static support.TestContext.getDriver;

public class JavaStepDefs {

    @Given("I hello world")
    public void iHelloWorld() {
        String message = "Hello World!";
        String text = "I'm an engineer!";
        System.out.println(message + " " + text);

        String firstName = "john";
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.getClass());
        System.out.println(firstName.length());
        System.out.println(firstName.equals("John"));
        System.out.println(firstName.contains("jo"));
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String sVar1, String sVar2) {
        System.out.println("First var is - " + sVar1);
        System.out.println("Second var is - " + sVar2);
        System.out.println("-------------------------");
        System.out.println("First var Uppercase is - " + sVar1.toUpperCase());
        System.out.println("Second var Uppercase is - " + sVar2.toUpperCase());
        System.out.println("-------------------------");
        System.out.println("First var length is - " + sVar1.length());
        System.out.println("Second var length is - " + sVar2.length());
        System.out.println("-------------------------");
        System.out.println("Exact comparison result - " + sVar1.equals(sVar2));
        System.out.println("-------------------------");
        System.out.println("Case insensetive comparison - " + sVar1.equalsIgnoreCase(sVar2));
        System.out.println("-------------------------");
        System.out.println(("Var1 contains Var2 - " + sVar1.contains(sVar2)));
    }

    @And("I say my name {string} {string} with my favorite color {string}")
    public void iSayMyNameWithMyFavoriteColor(String sFirstName, String sLastName, String sColor) {
        System.out.println("Hi, my name is " + sFirstName + " " + sLastName + ",my favorite color is " + sColor);
    }

    @And("I divide an integer {int} by integer {int}")
    public void iDivideAnIntegerByInteger(int iVar1, int iVar2) {
        System.out.println(iVar1 / iVar2);
    }

    @And("I divide an integer {int} by float {string}")
    public void iDivideAnIntegerByFloat(int iVar1, String sVar2) {
        System.out.println(iVar1 / Float.valueOf(sVar2));
    }

    @And("I perform actions with {int} and {int}")
    public void iPerformActionsWithAnd(int num1, int num2) {
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;
        System.out.println("Sum of " + num1 + " and " + num2 + " is " + sum);
        System.out.println("Difference of " + num1 + " and " + num2 + " is " + difference);
        System.out.println("Quotient of " + num1 + " and " + num2 + " is " + quotient);
        System.out.println("Product of " + num1 + " and " + num2 + " is " + product);
    }

    @And("I check for not favorite color is {string}")
    public void iCheckForNotFavoriteColorIs(String sColor) {
        String nonFavoriteColor = "Yellow";
        System.out.println("NonFavoriteColor matches - " + Boolean.toString(nonFavoriteColor.intern() == sColor.intern()));
    }

    @And("I compare {string} and {string} strings")
    public void iCompareAndStrings(String sVar1, String sVar2) {
        System.out.println("=>" + sVar1.equals(sVar2));
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String sURL) {
        String sPageUrl;
        switch (sURL.toLowerCase()) {
            case "Google":
                sPageUrl = "https://www.google.com/";
                break;
            case "sample":
                sPageUrl = "https://skryabin.com/webdriver/html/sample.html";
                break;
            case "Yahoo":
                sPageUrl = "https://yahoo.com/";
                break;
            default:
                sPageUrl = "There is no such page on Internet!";
                break;
        }
        System.out.println("URL for " + sURL + " is " + sPageUrl);
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String sVar1) {
        int iVar1;
        boolean bNotNumber = false;
        try {
            iVar1 = Integer.parseInt(sVar1);
        } catch (NumberFormatException e) {
            iVar1 = 0;
            bNotNumber = true;
        }
        if (bNotNumber) {
            System.out.println("Number is not a number (" + sVar1 + ")");
        } else if ((iVar1 >= 0) & (!bNotNumber)) {
            System.out.println("Number is positive (" + sVar1 + ")");
        } else {
            System.out.println("Number is negative (" + sVar1 + ")");
        }
    }

    @And("I print {string} th day of week")
    public void iPrintThDayOfWeek(String sDay1) {
        int iDay1 = 0;
        boolean bNumber = true;
        String[] sWeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        try {
            iDay1 = Integer.parseInt(sDay1);
        } catch (NumberFormatException e) {
            bNumber = false;
        }
        if ((bNumber) & ((iDay1 >= 1) & (iDay1 <= 7))) {
            System.out.println(sWeekDays[iDay1 - 1]);
        } else {
            System.out.println("Wrong day number");
        }
    }

    @Given("I go to {string} page")
    public void iGoToPage(String sPage) {
        switch (sPage.toLowerCase()) {
            case "google":
                getDriver().navigate().to("https://www.google.com/");
                break;
            case "quote":
                getDriver().navigate().to("https://skryabin.com/webdriver/html/quote.html");
                break;
            case "usps":
                getDriver().navigate().to("https://www.usps.com");
                break;
            case "converter":
                getDriver().navigate().to("https://www.unitconverters.net");
                break;
            case "calculator":
                getDriver().navigate().to("https://www.calculator.net");
                break;
            case "careers":
                getDriver().navigate().to("https://skryabin-careers.herokuapp.com");
                break;
            default:
                System.out.println("Unsupported page: " + sPage);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println("Current URL: " + getDriver().getCurrentUrl());
        System.out.println("Currnet page title: " + getDriver().getTitle());
        System.out.println("Window handles: " + getDriver().getWindowHandle());
        System.out.println("Page source:" + getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String sLayout) {
        System.out.println("Default resolution: " + getDriver().manage().window().getSize().toString());
        switch (sLayout.toLowerCase()) {
            case "phone":
                getDriver().manage().window().setSize(new Dimension(400, 768));
                break;
            case "desktop":
                getDriver().manage().window().setSize(new Dimension(1024, 768));
                break;
            default:
                System.out.println("Incorrect layout name input: " + sLayout);
        }
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Dmitry");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Odi");
        getDriver().findElement(By.xpath("//button[normalize-space()='Save']")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("dodintsov");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("odi@outlook.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("outlook.com");
        getDriver().findElement(By.xpath("//input[@name='email']")).submit();
        if (getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//input[@name='email']")).click();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@name='email']")).clear();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("odi@outlook.com");
            getDriver().findElement(By.xpath("//input[@name='email']")).submit();
        } else {
            throw new Error("Email field unexpected behavior");
        }
    }

    @Then("I verify that submitted fields saved correctly")
    public void iVerifyThatSubmittedFieldsSavedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("Dmitry Odi");
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo("dodintsov");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("odi@outlook.com");
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText()).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isEqualTo("[entered]");
        List<WebElement> lPassword = getDriver().findElements(By.xpath("//*[normalize-space()='12345']"));
        if (lPassword.size() > 0) {
            throw new Error("Password present on page and could be found!");
        }
    }

    @When("I fill out optional fields")
    public void iFillOutOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("89124530101");
        getDriver().findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys("01/01/1980");
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
        getDriver().findElement(By.xpath("//option[@value='Russia']")).click();
        getDriver().findElement(By.xpath("//input[@name='gender' and @value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("Some Address");
        getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Toyota']")).click();
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@name='contactPersonName']")).sendKeys("Dima");
        getDriver().findElement(By.xpath("//input[@name='contactPersonPhone']")).sendKeys("89124530101");
    }

    @And("I verify all optional fields saved correctly")
    public void iVerifyAllOptionalFieldsSavedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText()).isEqualTo("Russia");
        assertThat(getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText()).isEqualTo("01/01/1980");
        assertThat(getDriver().findElement(By.xpath("//b[@name='gender']")).getText()).isEqualTo("male");
        assertThat(getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText()).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='address']")).getText()).isEqualTo("Some Address");
        assertThat(getDriver().findElement(By.xpath("//b[@name='carMake']")).getText()).isEqualTo("Toyota");
        assertThat(getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText()).isEqualTo("accepted");
        assertThat(getDriver().findElement(By.xpath("//b[@name='contactPersonName']")).getText()).isEqualTo("Dima");
        assertThat(getDriver().findElement(By.xpath("//b[@name='contactPersonPhone']")).getText()).isEqualTo("89124530101");
    }

    @Given("I print numbers from zero to {int}")
    public void iPrintNumbersFromZeroTo(int iVar1) {
        for (int i = 0; i <= Math.abs(iVar1); i++) {
            System.out.println(((iVar1 < 0) & (i != 0)) ? ("-" + i) : i);
        }
    }

    @Given("I print integer array {string}")
    public void iPrintIntegerArray(String sArray1) {
        int[] iArray = convertStringArrayToInteger(sArray1);
        for (int i = 0; i < iArray.length; i++) {
            System.out.println(iArray[i]);
        }
    }

    @Given("I print even numbers from integer array {string}")
    public void iPrintEvenNumbersFromIntegerArray(String sArray1) {
        int[] iArray = convertStringArrayToInteger(sArray1);
        System.out.println("Even numbers form array is:");
        for (int el : iArray) {
            if ((el % 2) == 0) {
                System.out.println(el);
            }
        }
    }

    @Given("I check array {string} is empty")
    public void iCheckArrayIsEmpty(String sArray1) {
        int[] iArray = convertStringArrayToInteger(sArray1);
        System.out.println("Array is: " + ((iArray.length == 0) ? "is empty" : "not empty"));
    }

    public int[] convertStringArrayToInteger(String sArray1) {
        String[] sTempArr;
        String sTemp;
        if (sArray1.length() > 0) {
            sTemp = sArray1.replace(" ", "");
            sTempArr = sTemp.split(",");
        } else {
            sTempArr = new String[0];
        }
        int[] iArray = new int[sTempArr.length];
        if (iArray.length > 0) {
            for (int i = 0; i < iArray.length; i++) {
                iArray[i] = Integer.parseInt(sTempArr[i]);
            }
        }
        return iArray;
    }

    @Given("I check array {string} for element {int}")
    public void iCheckArrayForElement(String sArray1, int iEl) {
        int[] iArray = convertStringArrayToInteger(sArray1);
        String sFound = "haven't";
        for (int el : iArray) {
            if (el == iEl) {
                sFound = "have";
                break;
            }
        }
        System.out.println("We " + sFound + " this element in array.");
    }

    @Given("I work with some hashmap")
    public void iWorkWithSomeHashmap() {
        Map<String, String> myInfo = new HashMap<String, String>();
        myInfo.put("firstName", "Dima");
        myInfo.put("secondName", "Odi");
        myInfo.put("hometown", "Glazov");
        myInfo.put("favoriteFood", "someFood");

        System.out.println(myInfo.get("hometown"));
    }

    @Given("I sort an array with even and odd {string}")
    public void iSortAnArrayWithEvenAndOdd(String sArray1) {
        int[] iArray = convertStringArrayToInteger(sArray1);
        System.out.println("Original: " + Arrays.toString(iArray));
        for (int j = 0; j < iArray.length - 1; j++) {
            if (iArray[j] % 2 == 0) continue;
            int iMinIndex = j;
            int iMinValue = iArray[iMinIndex];
            for (int i = j + 1; i < iArray.length; i++) {
                if ((iArray[i] < iMinValue) && ((iArray[i] % 2) != 0)) {
                    iMinValue = iArray[i];
                    iMinIndex = i;
                }
            }
            int iTempValue = iArray[j];
            iArray[j] = iMinValue;
            iArray[iMinIndex] = iTempValue;
            System.out.println("Step " + j + " - " + Arrays.toString(iArray));
        }
    }

    public String[] convertStringToStringArray(String sArray1) {
        String[] sTempArr;
        String sTemp;
        if (sArray1.length() > 0) {
            sTemp = sArray1.replace(" ", "");
            sTempArr = sTemp.split(",");
        } else {
            sTempArr = new String[0];
        }
        return sTempArr;
    }

    @Given("I trying to combine array {string} with array {string}")
    public void iTryingToCombineArrayWithArray(String sArr1, String sArr2) {
        String[] aArr1 = convertStringToStringArray(sArr1);
        String[] aArr2 = convertStringToStringArray(sArr2);
        int iLen1 = aArr1.length;
        int iLen2 = aArr2.length;
        int iTotalLen = iLen1 + iLen2;
        String[] aRes = new String[iTotalLen];
        int i = 0;
        int j1 = 0;
        int j2 = 0;
        while (i < iTotalLen) {
            if ((j1 < aArr1.length)) {
                aRes[i] = aArr1[j1];
                i++;
                j1++;
            }
            if ((j2 < aArr2.length)) {
                aRes[i] = aArr2[j2];
                i++;
                j2++;
            }
        }
        System.out.println(Arrays.toString(aArr1));
        System.out.println(Arrays.toString(aArr2));
        System.out.println(Arrays.toString(aRes));
    }

    @Given("I check divisibility {int} by two and five")
    public void iCheckDivisibilityByTwoAndFive(int iNum) {
        System.out.println("Number: " + iNum + " " + checkDivisibility(iNum));
    }

    String checkDivisibility(int iNum) {
        if (iNum % 2 == 0 && iNum % 5 == 0) {
            return "divisible by 2 and 5";
        } else if (iNum % 2 == 0) {
            return "divisible by 2";
        } else if (iNum % 5 == 0) {
            return "divisible by 5";
        } else {
            return "not divisible by 2 or 5";
        }
    }

    @And("I swap {int} and {int} elements in array {string}")
    public void iSwapAndElementsInArray(int iEl1, int iEl2, String sArr) {
        int[] iArray = convertStringArrayToInteger(sArr);
        System.out.println("Original: " + Arrays.toString(iArray));
        System.out.println(" Swaped : " + Arrays.toString(swapElements(iEl1, iEl2, iArray)));
    }

    int[] swapElements(int iEl1, int iEl2, int[] iArray) {
        int iTemp = 0;
        if (iArray.length >= iEl1 && iArray.length >= iEl2 && iEl1 > 0 && iEl2 > 0) {
            iTemp = iArray[iEl1-1];
            iArray[iEl1-1] = iArray[iEl2-1];
            iArray[iEl2-1] = iTemp;
            return iArray;
        } else {
            System.out.println("Invalid input values.");
            return iArray;
        }
    }

    @And("I print all numbers from {int} to {int} with check multiplying by {int} and {int}")
    public void iPrintAllNumbersFromToWithCheckMultiplyingByAnd(int iStart, int iEnd, int iFirstMultipl, int iSecondMultipl) {
        if (iEnd >= iStart && iFirstMultipl != 0 && iSecondMultipl != 0) {
            for (int i = iStart; i <= iEnd; i++) {
                System.out.print(checkMultiplying(i, iFirstMultipl, iSecondMultipl) + " ");
            }
            System.out.println(); // just making new line at the end to looks good
        } else {
            System.out.println("Incorrect input values.");
        }
    }

    String checkMultiplying(int iNum, int iFirstMultipl, int iSecondMultipl) {
        if (iNum % iFirstMultipl == 0 && iNum % iSecondMultipl == 0) {
            return "FizzBuzz";
        } else if (iNum % iFirstMultipl == 0) {
            return "Fizz";
        } else if (iNum % iSecondMultipl == 0) {
            return "Buzz";
        } else {
            return String.valueOf(iNum);
        }
    }

    @And("I search the largest element in an array {string}")
    public void iSearchTheLargestElementInAnArray(String sArr) {
        int[] iArray = convertStringArrayToInteger(sArr);
        System.out.println("Largest element for array " + Arrays.toString(iArray) + " is " + String.valueOf(getLargestElement(iArray)));
    }

    int getLargestElement(int[] iArray) {
        int iLargest = iArray[0];
        for (int i = 1; i < iArray.length; i++) {
            if (iLargest < iArray[i]) {
                iLargest = iArray[i];
            }
        }
        return iLargest;
    }

    @And("I check divisibility {int} by {int} and {int}")
    public void iCheckDivisibilityByAnd(int iNum, int iDiv1, int iDiv2) {
        if (iDiv1 != 0 && iDiv2 != 0) {
            System.out.println("The number: " + iNum + checkDivisibilityCommon(iNum, iDiv1, iDiv2));
        } else {
            System.out.println("Incorrect input values.");
        }
    }

    String checkDivisibilityCommon(int iNum, int iDiv1, int iDiv2) {
        if (iNum % iDiv1 == 0 && iNum % iDiv2 == 0) {
            return " is divisible by " + iDiv1 + " and " + iDiv2;
        } else if (iNum % iDiv1 == 0) {
            return " is divisible by " + iDiv1;
        } else if (iNum % iDiv2 == 0) {
            return " is divisible by " + iDiv2;
        } else {
            return " doesn't divisible by " + iDiv1 + " and " + iDiv2;
        }
    }

    @And("I making string {string} reverse")
    public void iMakingStringReverse(String sStr) {
        System.out.println("Original: " + sStr);
        System.out.println("Reversed: " + reversingString(sStr));
    }

    String reversingString(String sStr) {
        StringBuilder result = new StringBuilder();
        for (int i = sStr.length() - 1; i >= 0; i--) {
            result.append(sStr.charAt(i));

        }
        return result.toString();
    }

    @And("I reverse words in sentence {string}")
    public void iReverseWordsInSentence(String sStr) {
        System.out.println("Original: " + sStr);
        System.out.println("Reversed: " + reversingWordsInString(sStr));
    }

    String reversingWordsInString(String sStr) {
        StringBuilder result = new StringBuilder();
        String[] sTempArr;
        if (sStr.length() > 0) {
            sStr = sStr.trim();
            sTempArr = sStr.split("\\b");
        } else {
            sTempArr = new String[0];
        }
        for (int i = sTempArr.length - 1; i >= 0; i--) {
            result.append( (sTempArr[i].hashCode() != 0) ? sTempArr[i].replaceAll("\\s+", " ") : "");
        }
        return result.toString().trim();
    }

    @And("I making string {string} reverse without extra variable")
    public void iMakingStringReverseWithoutExtraVariable(String sStr) {
        System.out.println("Original: " + sStr);
        System.out.println("Reversed: " + reversingStringWithoutExtraVariable(sStr));
    }

    private String reversingStringWithoutExtraVariable(String sStr) {
        for (int i = sStr.length() - 2; i >= 0; i--) {
            sStr += sStr.charAt(i);
        }
        return sStr.substring(sStr.length() / 2);
    }

    @Given("I search two highest element in array {string}")
    public void iSearchTwoHighestElementInArray(String sArray) {
        int[] aArray = convertStringArrayToInteger(sArray);
        if (aArray.length > 2) {
            int iFirstMax = aArray[0];
            int iSecondMax = aArray[1];
            for (int i = 2; i < aArray.length; i++) {
                if (aArray[i] > iFirstMax) {
                    iSecondMax = iFirstMax;
                    iFirstMax = aArray[i];
                } else if (aArray[i] > iSecondMax) {
                    iSecondMax = aArray[i];
                }
            }
            System.out.println("First highest element is - " +  iFirstMax);
            System.out.println("Second highest element is - " + iSecondMax);
        } else if (aArray.length == 2) {
            System.out.println("First highest element is - " + Math.max(aArray[0], aArray[1]));
            System.out.println("Second highest element is - " + Math.min(aArray[0], aArray[1]));
        } else {
            throw new Error("Array looks too small.");
        }
    }

    @Given("I search duplicates within an array {string}")
    public void iSearchDuplicatesWithinAnArray(String sArray) {
        int[] aArray = convertStringArrayToInteger(sArray);
        int count = 0;
        String positions = "";
        HashMap<Integer, Integer> mapCount = new HashMap<>();
        HashMap<Integer, String> mapPositions = new HashMap<>();
        for (int i = 0; i < aArray.length; i++) {
            if (!mapCount.containsKey(aArray[i])) {
                mapCount.put(aArray[i], 1);
                mapPositions.put(aArray[i], String.valueOf(i) + ",");
            } else {
                continue;
            }
            for (int j = i + 1; j < aArray.length; j++) {
                if (aArray[j] == aArray[i]) {
                    count = mapCount.get(aArray[i]);
                    positions = mapPositions.get(aArray[i]);
                    mapCount.put(aArray[i], count + 1);
                    mapPositions.put(aArray[i], positions + j + ",");
                }
            }
        }
        Set<Integer> keys = mapCount.keySet();
        if (mapCount.containsValue(2)) {
            for (int el : keys) {
                if (mapCount.get(el) > 1) {
                    System.out.println("Value: " + String.valueOf(el) + " repeats by " + mapCount.get(el) + " times at " + mapPositions.get(el) + " positions");
                }
            }
        } else {
            throw new Error("There is no duplicates within an array.");
        }
    }

    @Given("I check is word {string} palindrome")
    public void iCheckIsWordPalindrome(String sWord) {
        System.out.println("Word: " + sWord + checkWordIsPalindrome(sWord));
    }

    public String checkWordIsPalindrome(String sWord) {
        String result = "";
        for (int i = sWord.length() - 1; i >= 0; i--) {
            result += sWord.charAt(i);
        }
        return (sWord.equals(result)) ? " is palindrome" : " isn't palindrome";
    }

    public String checkWordIsPalindromeMethod2(String sWord) {
        for (int i = 0; i < (sWord.length() / 2); i++) {
            if (sWord.charAt(i) != sWord.charAt((sWord.length()-1) - i) ) {
                return " isn't palindrome";
            }
        }
        return " is palindrome";
    }

    @Given("I check is word {string} palindrome with other method")
    public void iCheckIsWordPalindromeWithOtherMethod(String sWord) {
        System.out.println("Word: " + sWord + checkWordIsPalindromeMethod2(sWord));
    }

    @Given("I print two max numbers in an array {string}")
    public void iPrintTwoMaxNumbersInAnArray(String sArray) {
        int[] aArray = convertStringArrayToInteger(sArray);
        if (aArray.length > 2) {
            int iTemp;
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < aArray.length; j++) {
                    if (aArray[j] > aArray[i]) {
                        iTemp = aArray[i];
                        aArray[i] = aArray[j];
                        aArray[j] = iTemp;
                    }
                }
            }

            System.out.println("First highest element is - " +  aArray[0]);
            System.out.println("Second highest element is - " + aArray[1]);
        } else if (aArray.length == 2) {
            System.out.println("First highest element is - " + Math.max(aArray[0], aArray[1]));
            System.out.println("Second highest element is - " + Math.min(aArray[0], aArray[1]));
        } else {
            throw new Error("Array looks too small.");
        }
    }

    @Given("I search two element in array {string} results in sum of {int}")
    public void iSearchTwoElementInArrayResultsInSumOf(String sArray, int iSum) {
        int[] aArray = convertStringArrayToInteger(sArray);
        String sLine = "";
        if (aArray.length >= 2) {
            int iTemp;
            for (int i = 0; i < aArray.length; i++) {
                for (int j = i + 1; j < aArray.length; j++) {
                    if (aArray[j] + aArray[i] == iSum) {
                        sLine = "(" + Integer.toString(aArray[i]) + " + " + Integer.toString(aArray[j]) + ").";
                        System.out.println("Elements found at: " + i + " and " + j + " positions " + sLine);
                    }
                }
            }
        } else {
            throw new Error("Array looks too small.");
        }
        if (sLine == "") {
            System.out.println("No elements found.");
        }
    }

    @Given("I check number {int} is a prime")
    public void iCheckNumberIsAPrime(int iNum) {
        if (iNum <= 1) {
            System.out.println("Number " + iNum + " is not a prime.");
            return;
        }
        for (int i = 2; i <= Math.sqrt(iNum); i++) {
            if (iNum % i == 0) {
                System.out.println("Number " + iNum + " is not a prime.");
                return;
            }
        }
        System.out.println("Number " + iNum + " is a prime.");
    }

    @Given("I calculate factorial for {int}")
    public void iCalculateFactorialFor(int iNum) {
        System.out.println("Factorial for " + iNum + " is " + getFactorial(iNum));
    }

    int getFactorial(int iNum) {
        int iFa = iNum;
        if (iNum == 1) {
            return iFa;
        }
        iFa *= getFactorial(iNum - 1);
        return iFa;
    }

    @Given("I work with classes")
    public void iWorkWithClasses() {
        System.out.println();
        System.out.println();

        Animal cat = new Cat("Tom");
        cat.sleep();
        cat.walk();
        cat.speak();
        cat.eat("fish");
        System.out.println(cat.getName());

        System.out.println();

        Animal anotherCat = new Cat();
        anotherCat.sleep();
        anotherCat.speak();
        System.out.println("Street cat name is " + anotherCat.getName());

        System.out.println();
        System.out.println();

        Animal dog = new Dog();
        System.out.println("Dog name is " + dog.getName());
        dog.setName("Bobby");
        dog.eat("bone");
        dog.sleep();
        dog.speak();

        System.out.println();
        System.out.println();

        Animal kang = new Kangaroo("Ruth");
        kang.speak();
        kang.sleep();
        kang.eat("Pelmeni");
        kang.jump();
        kang.setBag(true);

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(anotherCat);
        animals.add(dog);
        animals.add(kang);
        printAnimalNames(animals);
    }

    @Given("I work with Kangaroo")
    public void iWorkWithKangaroo() {
        Animal kang = new Kangaroo("Ruth");
        kang.speak();
        kang.sleep();
        kang.eat("Pelmeni");
        kang.jump();
    }

    void printAnimalNames(List<Animal> animals) {
        System.out.println();
        System.out.println("All animal names >>>> ");
        for (Animal animal : animals) {
            System.out.println(animal.getName());
            animal.sleep();
            animal.speak();
        }
    }
}