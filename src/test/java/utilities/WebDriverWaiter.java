package utilities;

import core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverWaiter {
    private static final Wait<WebDriver> wait;

    static{
        wait = new WebDriverWait(Driver.getDriver(), Driver.explicitTime);
    }

    public static void pause(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilTitleToBe(String title){
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitUntilTitleToContain(String partialTitle){
        wait.until(ExpectedConditions.titleContains(partialTitle));
    }

    public static void waitUntilURLToBe(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void waitUntilURLToContain(String partialURL){
        wait.until(ExpectedConditions.urlContains(partialURL));
    }

    public static void waitUntilURLToMatch(String regex){
        wait.until(ExpectedConditions.urlMatches(regex));
    }

    public static void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementsToBeVisible(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementTextPresentToBe(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
