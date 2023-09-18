package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.dzenNews.DzenNewsPageObjects;
import pageobjects.vkApp.MainPage;
import pageobjects.vkApp.PersonalPage;
import pageobjects.vkApp.ServicesPage;
import pageobjects.vkApp.VkPageMessage;

public class Driver {
    protected static AndroidDriver<AndroidElement> driver;
    protected static MainPage mainPage;
    protected static Helper helper;
    protected static Watcher watcher;
    protected static ServicesPage servicesPage;
    protected static VkPageMessage vkPageMessage;
    protected static PersonalPage personalPage;
    protected static DzenNewsPageObjects dzenNewsPageObjects;

    public static void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:platformVersion", "13");
//        desiredCapabilities.setCapability("appium:deviceName", "CK7n");
        desiredCapabilities.setCapability("appium:automationName", "uiAutomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
        mainPage = new MainPage(driver);
        helper = new Helper(driver);
        watcher = new Watcher(driver);
        servicesPage = new ServicesPage(driver);
        vkPageMessage = new VkPageMessage(driver);
        personalPage = new PersonalPage(driver);
        dzenNewsPageObjects = new DzenNewsPageObjects(driver);

    }
}
