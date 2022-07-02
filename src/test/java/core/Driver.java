package core;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver extends Environment {

    private Driver(){}

    private static WebDriver driver;
    private static final DesiredCapabilities caps = new DesiredCapabilities();

    public static WebDriver getDriver() {
        setEnvironment();
        if (driver == null) {
            if (isMobile) {
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
                driver = new RemoteWebDriver(appiumURL, caps);
            } else {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver = new SafariDriver();
                        break;
                    case "headless":
                        driver = new HtmlUnitDriver();
                        break;
                    default:
                        throw new NotFoundException("WebDriver is not set properly!");
                }
                if (!browser.equalsIgnoreCase("headless")) {
                    driver.manage().window().maximize();
                }
            }
            driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
            driver.get(applicationURL);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try{
                driver.manage().deleteAllCookies();
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                driver.quit();
                driver = null;
            }
        }
    }
}
