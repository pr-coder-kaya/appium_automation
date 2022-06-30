package pages.carvana_pages;

import expected_texts.CarvanaExpectedTexts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class CarvanaCarFinderPage extends BasePage {
    public CarvanaCarFinderPage(){
        super();
    }

    //Common elements for desktop and mobile view
    @FindBy(tagName = "h1")
    private WebElement mainHeader;

    @FindBy(tagName = "h3")
    private WebElement subHeader;

    @FindBy(css = "a[data-qa='router-link']")
    private WebElement tryCarFinderLink;

    @FindBy(css = "div[data-qa='headline']")
    private WebElement headline;

    @FindBy(css = "div[data-qa='sub-heading']")
    private WebElement subHeadline;

    public void validateMainHeader(){
        Assert.assertEquals(mainHeader.getText(), CarvanaExpectedTexts.CarFinder.main_header);
    }

    public void validateSubHeader(){
        Assert.assertEquals(subHeader.getText(), CarvanaExpectedTexts.CarFinder.sub_header);
    }

    public void validateTryCarFinderLink(){
        Assert.assertEquals(tryCarFinderLink.getText(), CarvanaExpectedTexts.CarFinder.try_car_finder_link);
    }

    public void clickOnTryCarFinderLink(){
        tryCarFinderLink.click();
    }

    public void validateHeadline(){
        Assert.assertEquals(headline.getText(), CarvanaExpectedTexts.CarFinder.headline);
    }

    public void validateSubHeadline(){
        Assert.assertEquals(subHeadline.getText(), CarvanaExpectedTexts.CarFinder.sub_headline);
    }
}
