package scripts.carvana_scripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.carvana_pages.CarvanaCarFinderPage;
import pages.carvana_pages.CarvanaHomePage;
import scripts.Base;

public class CarvanaTest extends Base {

    @BeforeClass
    public void setPages(){
        carvanaHomePage = new CarvanaHomePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
    }

    @Test
    public void validateCarFinder(){
        carvanaHomePage.clickOnCarFinderLink();
        carvanaCarFinderPage.validateMainHeader();
        carvanaCarFinderPage.validateSubHeader();
        carvanaCarFinderPage.validateTryCarFinderLink();
        carvanaCarFinderPage.clickOnTryCarFinderLink();
        carvanaCarFinderPage.validateHeadline();
        carvanaCarFinderPage.validateSubHeadline();
    }
}
