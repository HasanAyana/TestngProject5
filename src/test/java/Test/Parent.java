package Test;

import Test.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Parent extends BaseDriverParametre {

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element);
        scrolltoElement(element);
        element.clear();
        element.sendKeys(value);

    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrolltoElement(element);
        element.click();
    }

    public void waitUntilVisible(WebElement element) {


        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrolltoElement(WebElement element) {
        actions.scrollToElement(element);

    }
    public void verifyContainsTextFunction(WebElement element, String value)
    {waitUntilVisible(element); // gözükene kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"The text you searched could'nt be find");
    }
}