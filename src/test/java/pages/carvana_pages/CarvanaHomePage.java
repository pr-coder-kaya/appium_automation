package pages.carvana_pages;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.WebDriverWaiter;

public class CarvanaHomePage extends BasePage {
    public CarvanaHomePage(){
        super();
    }

    //Desktop element locators
    @FindBy(css = "a[data-cv-test*='headerCarFinderLink']")
    private WebElement carFinderLink;


    //Mobile element locators
    @FindBy(css = "div[data-cv-test='headerMobileMenuOpen']")
    private WebElement headerMobileMenuOpen;

    @FindBy(css = "a[data-cv-test*='headerMobileCarFinderLink']")
    private WebElement carFinderMobileLink;

    public void clickOnCarFinderLink(){
        if(isMobile){
            headerMobileMenuOpen.click();
            //TODO - Add mobile browser explicit wait
            WebDriverWaiter.pause(2);
            carFinderMobileLink.click();
        }
        else {
            int attempt = 1;
            while(attempt < 5){
                try{
                    carFinderLink.click();
                    break;
                }
                catch (StaleElementReferenceException e){
                    webDriver.navigate().refresh();
                    WebDriverWaiter.pause(attempt++);
                }
            }
        }
    }
}
