package utilities;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementActions {
    private static Actions actions;

    static{
        actions = new Actions(Driver.getDriver());
    }

    public static void actionsMoveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }

    public static void actionsDoubleClick(WebElement element){
        actions.doubleClick(element).perform();
    }

    public static void actionsRightClick(WebElement element){
        actions.contextClick(element).perform();
    }

    public static void actionsClickAndHold(WebElement element){
        actions.clickAndHold(element).perform();
    }

    public static void actionsRelease(WebElement element){
        actions.release(element).perform();
    }

    public static void actionsDragAndDrop(WebElement sourceElement, WebElement targetElement){
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }
}
