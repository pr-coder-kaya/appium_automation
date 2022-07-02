package pages;

import core.Driver;
import core.Environment;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Environment{
    public BasePage(){
            PageFactory.initElements(Driver.getDriver(), this);
    }
}
