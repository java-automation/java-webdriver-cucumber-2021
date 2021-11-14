package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;


import static support.TestContext.getDriver;

public class Day5hwStepDefs {
    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num1) {
        if (num1 > 0) {
            System.out.println("Number is positive");
        } else if (num1 == 0) {
            System.out.println("Number = 0");
        } else System.out.println("Number is negative");
    }

    @And("I print {int} day of week")
    public void iPrintDayOfWeek(int arg0) {
        switch (arg0) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Unknown Day: " + arg0);
        }
    }

    @Given("I go to {string} page")
    public void iGoToPage(String arg0) {
        System.out.println("Search1");
        switch (arg0.toLowerCase()) {
            case "google" -> System.out.println("https://www.google.com");
            case "quote" -> System.out.println("https://skryabin.com/webdriver/html/sample.html");
            default -> throw new Error("Unknown url_s1: " + arg0);
            //default -> System.out.println("Unknown url_s1: " + arg0);
        }
        System.out.println();
        System.out.println("Search2");
        String[][] urlBase = {
                {"Google", "Bing", "quote", "Quote"},
                {"https://www.google.com", "https2", "https://skryabin.com/webdriver/html/sample.html", "https4"}
        };

        for (int i = 0; i < urlBase[0].length; i++) {
            if (arg0.equalsIgnoreCase(urlBase[0][i])) {
                System.out.println("Found array index: " + i);
                System.out.println("For name " + urlBase[0][i] + ", URL: " + urlBase[1][i]);
            }
        }
    }

    @Given("I go to {string} page again")
    public void iGoToPageAgain(String arg0) {
        //String url = switch (arg0.toLowerCase()) {
        switch (arg0.toLowerCase()) {
            case "google" -> getDriver().get("https://www.google.com/");
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
            default -> System.out.println("Unsupported url_s1: " + arg0);
        }
        //getDriver().get(url);
    }

    @And("I print page details")
    public void iPrintPageDetails() throws InterruptedException {
        System.out.println("Url: " + getDriver().getCurrentUrl());
        System.out.println("Title: " + getDriver().getTitle());
        System.out.println("Win handles: " + getDriver().getWindowHandles());
        // System.out.println("Source: " + getDriver().getPageSource());
        Thread.sleep(500);
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Given("I change resolution to {string}")
    public void iChangeResolutionTo(String size) throws InterruptedException {
        // int width;
        // int height;
        switch (size.toLowerCase()) {
            case "phone" -> {
                //width = 400;
                // height = 768;
                getDriver().manage().window().setSize(new Dimension(400, 768));
            }
            case "desktop" -> {
                //width = 1024;
                // height = 768;
                getDriver().manage().window().setSize(new Dimension(1024, 768));
            }
            default -> System.out.println("Unsupported resolution: " + size);
        }
        //getDriver().manage().window().setSize(new Dimension(400, 768));
        Thread.sleep(3000);
    }
}


