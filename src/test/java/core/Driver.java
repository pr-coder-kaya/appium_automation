package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
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

    protected static WebDriver webDriver;
    protected static AppiumDriver appiumDriver;
    private static DesiredCapabilities caps = new DesiredCapabilities();

    static{
        if(isMobile && !isBrowser) appiumDriver = getAppiumDriver();
        else {
            webDriver = getWebDriver();
            webDriver.get(webAppURL);
        }
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            if (isMobile && isBrowser) {
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
                webDriver = new RemoteWebDriver(appiumURL, caps);
            } else {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        webDriver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        webDriver = new FirefoxDriver();
                        break;
                    case "safari":
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        webDriver = new SafariDriver();
                        break;
                    case "headless":
                        webDriver = new HtmlUnitDriver();
                        break;
                    default:
                        throw new NotFoundException("WebDriver is not set properly!");
                }
                if (!browser.equalsIgnoreCase("headless")) {
                    webDriver.manage().window().maximize();
                }
            }
            webDriver.manage().timeouts().pageLoadTimeout(implicitTime, TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.manage().deleteAllCookies();
            webDriver.quit();
            webDriver = null;
        } else if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }

    public static AppiumDriver getAppiumDriver() {
        if (isMobile && !isBrowser) {
            caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability("appPackage", appPackage);
            caps.setCapability("appActivity", appActivity);

            switch (platformName.toLowerCase()) {
                case "android":
                    appiumDriver = new AndroidDriver<AndroidElement>(appiumURL, caps);
                    break;
                case "ios":
                    appiumDriver = new IOSDriver<IOSElement>(appiumURL, caps);
                    break;
                default:
                    throw new NotFoundException("AppiumDriver is not set properly!");
            }
            return appiumDriver;
        }
        return null;
    }
}
