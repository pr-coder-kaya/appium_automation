import com.sun.deploy.util.Waiter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Demo {

    @Test
    public void firstTest() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4_28");
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        //caps.setCapability("appPackage", "com.android.chrome");
        //caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        /*
        YOU CAN USE BELOW CODE START APPIUM SERVER WITH NO MANUAL EFFORT
        AndroidDriver<AndroidElement> driver = null; //new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4773/wd/hub"), dc);;
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        driver = new AndroidDriver<AndroidElement>(service, dc);
         */


        URL url = new URL("http://127.0.0.1:4723/wd/hub/");
        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("TechGlobal");

        //Thread.sleep(10000);



        //BROWSER TESTING FOR WEB APPLICATION BUT ON MOBILE DEVICES
        WebDriver driver = new RemoteWebDriver(url, caps);

        driver.get("https://www.carvana.com");

        //driver.findElement(By.name("q")).sendKeys("Appium" + Keys.ENTER);

        Thread.sleep(10000);

        System.out.println("TEST IS HERE!!!");
        Assert.assertTrue(true);
    }
}
