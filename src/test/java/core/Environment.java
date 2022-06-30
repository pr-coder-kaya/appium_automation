package core;

import java.net.MalformedURLException;
import java.net.URL;

public class Environment {
    public static final boolean isMobile = Boolean.parseBoolean(ConfigReader.getProperty("isMobile"));
    public static final boolean isBrowser = Boolean.parseBoolean(ConfigReader.getProperty("isBrowser"));
    public static final String platformName = ConfigReader.getProperty("platformName");
    public static final String deviceName = ConfigReader.getProperty("deviceName");
    public static final String appPackage = ConfigReader.getProperty("appPackage");
    public static final String appActivity = ConfigReader.getProperty("appActivity");
    public static final String browser = ConfigReader.getProperty("browser");
    public static final String appURL = ConfigReader.getProperty("webAppUrl");
    public static final int implicitTime = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
    public static final int explicitTime = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
    public static URL appiumURL;

    static {
        try {
            appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
