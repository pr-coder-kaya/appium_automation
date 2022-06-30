package pages;

import core.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Driver {
    public BasePage(){
        if(isMobile && !isBrowser) PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        else PageFactory.initElements(webDriver, this);
    }
}
