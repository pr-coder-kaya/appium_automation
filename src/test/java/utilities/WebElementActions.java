package utilities;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementActions {
    private static Actions actions;

    static{
        actions = new Actions(Driver.getWebDriver());
    }

    public static void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }

    public static void doubleClick(WebElement element){
        actions.doubleClick(element).perform();
    }

    public static void rightClick(WebElement element){
        actions.contextClick(element).perform();
    }

    public static void clickAndHold(WebElement element){
        actions.clickAndHold(element).perform();
    }

    public static void release(WebElement element){
        actions.release(element).perform();
    }

    public static void dragAndDrop(WebElement sourceElement, WebElement targetElement){
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }
}
