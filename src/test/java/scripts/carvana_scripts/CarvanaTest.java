package scripts.carvana_scripts;

import org.testng.annotations.Test;
import pages.carvana_pages.CarvanaSellTradePage.Toggle;
import scripts.Base;

public class CarvanaTest extends Base {

    @Test(priority = 1, description = "Validate CAR FINDER menu item")
    public void validateCarFinder(){
        carvanaHomePage.clickOnCarFinderLink();
        carvanaCarFinderPage.validateMainHeader();
        carvanaCarFinderPage.validateSubHeader();
        carvanaCarFinderPage.validateTryCarFinderLink();
        carvanaCarFinderPage.clickOnTryCarFinderLink();
        carvanaCarFinderPage.validateHeadline();
        carvanaCarFinderPage.validateSubHeadline();
    }

    @Test(priority = 2, description = "Validate SELL/TRADE invalid vin search")
    public void validateInvalidVINSearch(){
        carvanaHomePage.clickOnSellTradeLink();
        carvanaSellTradePage.validateMainHeader();
        carvanaSellTradePage.validateSubHeader();
        carvanaSellTradePage.clickOnToggleButton(Toggle.VIN);
        carvanaSellTradePage.sendKeysToVINInputBox(carvanaTestData.getInvalid_VIN());
        carvanaSellTradePage.clickOnGetMyOfferButton();
        carvanaSellTradePage.validateInvalidVINErrorMessage();
    }
}
