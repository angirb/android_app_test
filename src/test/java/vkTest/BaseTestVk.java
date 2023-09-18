package vkTest;


import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.Driver;
import utils.vkSteps.LoginSteps;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;

import static io.appium.java_client.android.nativekey.AndroidKey.BACK;
import static io.appium.java_client.android.nativekey.AndroidKey.HOME;
import static utils.vkSteps.LogoutSteps.logOut;

public class BaseTestVk extends Driver {


    @BeforeClass
    public static void beforeClass() throws MalformedURLException, InterruptedException {

        setUp(); // use set up methods
        LoginSteps.login(); // before starting the test login into account
        watcher.processPopupIfNeeded();
        watcher.systemPopupNotification();
        driver.pressKey(new KeyEvent(HOME));
        driver.pressKey(new KeyEvent(BACK));
    }

    @AfterClass
    public static void afterClass() {
        openVk();
        logOut();
        driver.pressKey(new KeyEvent(BACK));
        driver.quit();

    }

    public static void openVk() {
        helper.swipeUp(driver, 500); // swipe up on main screen to open all apps menu
        mainPage.clickVkApp(); // search for VK app, if cant be found it will scroll down until it finds and clicks
    }

    protected void tearDown() throws InterruptedException {
        driver.pressKey(new KeyEvent(HOME));
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Thread.sleep(1000);
        helper.isDisplayed(mainPage.clearAllTasks);
        helper.clickElement(mainPage.clearAllTasks);
    }

}
