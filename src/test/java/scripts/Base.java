package scripts;

import core.Driver;
import org.testng.annotations.AfterMethod;
import pages.carvana_pages.CarvanaCarFinderPage;
import pages.carvana_pages.CarvanaHomePage;

public class Base extends Driver {

    protected CarvanaHomePage carvanaHomePage;
    protected CarvanaCarFinderPage carvanaCarFinderPage;

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
