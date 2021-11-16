package definitions;

import io.cucumber.java.en.Given;

public class Day6hwStepDefs {

    @Given("I print number n: {double}")
    public void iPrintNumberN(double n) {
        int numDoubles = 0;
        for (double x = 1.0; x <= n; x = Math.nextUp(x)) {
            System.out.println(x);
            numDoubles++;
        }
        System.out.println(numDoubles);
    }

    @Given("I print two int numbers : {int}, {int}")
    public void iPrintTwoIntNumbers(int n1, int n2) {
        for (int x = n1; x <= n2; x++) {
            System.out.println(x);
        }
    }

    @Given("I create and print intArray")
    public void iCreateAndPrintIntArray() {
        int[] intAray = {1, 2, 3, 4, 5};
        for (int anyElem : intAray) {
            System.out.println(anyElem);
        }
    }

    @Given("I print even numbers from array")
    public void iPrintEvenNumbersFromArray() {
        int[] intAray = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int anyElem : intAray) {
            if (anyElem % 2 == 0) {
                System.out.println(anyElem);
            }
        }
    }

    @Given("I check if String array is empty")
    public void iCheckIfStringArrayIsEmpty() {
        String[] strArray = new String[5];
        strArray[1] = "one";
        //strArray[2] = "2";

        boolean isEmpty = true;

        for (String anyStr : strArray) {
            if (anyStr != null) {
                System.out.println("Array is not  empty");
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("Array is empty");
        }
    }

    @Given("I check if String array contains another element")
    public void iCheckIfStringArrayContainsAnotherElement() {
        String[] strArray = new String[5];
        strArray[1] = "one";
        strArray[2] = "2";

        for (String anyStr : strArray) {

            if (anyStr != null) {
                System.out.println(anyStr);
            }
        }
    }
}






