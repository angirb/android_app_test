package dzenNewsTests;

import static io.appium.java_client.android.nativekey.AndroidKey.HOME;

import org.junit.Before;

import java.net.MalformedURLException;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.Driver;

public class BaseTestDzen extends Driver {
    @Before
    public void before() throws MalformedURLException, InterruptedException {
        setUp();
    }


    public static void openDzenNewsApp() {
        helper.swipeUp(driver, 500);
        dzenNewsPageObjects.clickDzenNewsApp();
    }


    protected static void closeDzenNewsApp() throws InterruptedException {
        driver.pressKey(new KeyEvent(HOME));
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Thread.sleep(1000);
        watcher.closeAllTasks();
    }
}
