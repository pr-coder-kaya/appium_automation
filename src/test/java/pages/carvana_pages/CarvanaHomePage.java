package pages.carvana_pages;


import core.Driver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.WebDriverWaiter;

public class CarvanaHomePage extends BasePage {
    public CarvanaHomePage() {
        super();
    }


    //Desktop element locators
    @FindBy(css = "a[data-cv-test='headerCarFinderLink']")
    private WebElement carFinderLink;

    @FindBy(css = "a[data-cv-test='headerTradesLink']")
    private WebElement sellTradeLink;


    //Mobile element locators
    @FindBy(css = "div[data-cv-test='headerMobileMenuOpen']")
    private WebElement mobileHeaderMenuOpen;

    @FindBy(css = "a[data-cv-test*='headerMobileCarFinderLink']")
    private WebElement mobileCarFinderLink;

    @FindBy(css = "a[data-cv-test='headerMobileTradesLink']")
    private WebElement mobileSellTradeLink;

    public void clickOnCarFinderLink() {
        if (isMobile) {
            mobileHeaderMenuOpen.click();
            //TODO - Add mobile browser explicit wait
            WebDriverWaiter.pause(3);
            mobileCarFinderLink.click();
        } else {
            //TODO - Add mobile browser explicit wait
            WebDriverWaiter.pause(3);
            carFinderLink.click();
        }
    }

    public void clickOnSellTradeLink() {
        if (isMobile) {
            mobileHeaderMenuOpen.click();
            //TODO - Add mobile browser explicit wait
            WebDriverWaiter.pause(3);
            mobileSellTradeLink.click();
        } else {
            //TODO - Add mobile browser explicit wait
            WebDriverWaiter.pause(3);
            sellTradeLink.click();
        }
    }
}
