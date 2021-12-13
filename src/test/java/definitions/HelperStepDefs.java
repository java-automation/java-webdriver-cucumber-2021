// Created by Gavrilova Irina 12/11/2021

package definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static support.TestContext.getDriver;

public class HelperStepDefs {

    public static void type(String xpath, String text) {
        click(xpath);
        getDriver().findElement(By.xpath(xpath)).clear();
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    public static String getText(String xpath) {
        return getWebElement(xpath).getText();
    }

    public static void click(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public static WebElement getWebElement(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    static WebElement getWebElementFromListByAttributeValue(String xpath, String attributeName, String attributeValue) {
        List<WebElement> menuItemList = getDriver().findElements(By.xpath(xpath));
        List<String> menuItemAttributes = new ArrayList<>();
        menuItemList.forEach(el -> menuItemAttributes.add(el.getAttribute(attributeName)));
        return menuItemList.get(menuItemAttributes.indexOf(attributeValue));
    }
    static WebElement getWebElementFromListByPartOfAttributeValue(String xpath, String attributeName, String partOfAttributeValue) {
        List<WebElement> menuItemList = getDriver().findElements(By.xpath(xpath));
        List<String> menuItemAttributes = new ArrayList<>();
        menuItemList.forEach(el -> {
            menuItemAttributes.add(el.getAttribute(attributeName));
            System.out.println(el.getAttribute(attributeName));
        });
        String attributeValue = menuItemAttributes.stream().filter(el->el.contains(partOfAttributeValue)).collect(Collectors.toList()).get(0);
        System.out.println("attributeValue = " + attributeValue);
        return menuItemList.get(menuItemAttributes.indexOf(attributeValue));
    }

    public static void selectByValue(String xpath, String value) {
        Select list = new Select(getDriver().findElement(By.xpath(xpath)));
        click(xpath);
        list.selectByValue(value);
    }
    public static void setSize(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        getDriver().manage().window().setSize(dimension);
    }
}
