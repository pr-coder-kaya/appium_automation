package pages.carvana_pages;

import expected_texts.CarvanaExpectedTexts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;
import utilities.WebDriverWaiter;

import java.util.List;

public class CarvanaSellTradePage extends BasePage {
    public CarvanaSellTradePage(){
        super();
    }

    public enum Toggle{
        VIN, PLATE
    }

    //Common elements for desktop and mobile view
    @FindBy(css = "div.kjhwtS")
    private WebElement mainHeader;

    @FindBy(css = "div.lnhlkr")
    private WebElement subHeader;

    @FindBy(css = "button[data-cv-test*='Toggle']")
    private List<WebElement> toggles;

    @FindBy(css = "div[data-cv-test*='heroVinEntryInput']>input")
    private WebElement VINInputBox;

    @FindBy(css = "button[data-cv-test*='heroGetMyOfferButton']")
    private WebElement getMyOfferButton;

    @FindBy(css = "div.kjoUgV")
    private WebElement invalidVINErrorMessage;

    public void validateMainHeader(){
        Assert.assertEquals(mainHeader.getText(), CarvanaExpectedTexts.SellTrade.main_header);
    }

    public void validateSubHeader(){
        Assert.assertEquals(subHeader.getText(), CarvanaExpectedTexts.SellTrade.sub_header);
    }

    public void clickOnToggleButton(Toggle toggle){
        for(WebElement element: toggles){
            if(element.getText().equals(toggle.toString())){
                element.click();
                break;
            }
        }
    }

    public void sendKeysToVINInputBox(String keys){
        VINInputBox.sendKeys(keys);
    }

    public void clickOnGetMyOfferButton(){
        getMyOfferButton.click();
    }

    public void validateInvalidVINErrorMessage(){
        WebDriverWaiter.waitUntilElementTextPresentToBe(invalidVINErrorMessage, CarvanaExpectedTexts.SellTrade.invalid_VIN_error_message);
        Assert.assertEquals(invalidVINErrorMessage.getText(), CarvanaExpectedTexts.SellTrade.invalid_VIN_error_message);
    }
}
