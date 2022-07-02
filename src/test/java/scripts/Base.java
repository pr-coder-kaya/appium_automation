package scripts;

import core.Driver;
import core.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.carvana_pages.CarvanaCarFinderPage;
import pages.carvana_pages.CarvanaHomePage;
import pages.carvana_pages.CarvanaSellTradePage;
import test_data.CarvanaTestData;


public class Base extends Environment {

    protected WebDriver webDriver;
    protected CarvanaTestData carvanaTestData;
    protected CarvanaHomePage carvanaHomePage;
    protected CarvanaCarFinderPage carvanaCarFinderPage;
    protected CarvanaSellTradePage carvanaSellTradePage;

    @BeforeMethod
    public void setDriver() {
        webDriver = Driver.getDriver();
        carvanaTestData = new CarvanaTestData();
        carvanaHomePage = new CarvanaHomePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
        carvanaSellTradePage = new CarvanaSellTradePage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
