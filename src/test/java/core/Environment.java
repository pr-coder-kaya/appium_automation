package core;

import java.net.MalformedURLException;
import java.net.URL;

public class Environment {
    public static boolean isMobile;
    public static String platformName;
    public static String deviceName;
    public static String appPackage;
    public static String appActivity;
    public static String browser;
    public static String applicationURL;
    public static int implicitTime;
    public static int explicitTime;
    public static URL appiumURL;

    public static void setEnvironment(){
        isMobile = Boolean.parseBoolean(ConfigReader.getProperty("isMobile"));
        platformName = ConfigReader.getProperty("platformName");
        deviceName = ConfigReader.getProperty("deviceName");
        appPackage = ConfigReader.getProperty("appPackage");
        appActivity = ConfigReader.getProperty("appActivity");
        browser = ConfigReader.getProperty("browser");
        applicationURL = ConfigReader.getProperty("applicationURL");
        implicitTime = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        explicitTime = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
        try {
            appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
