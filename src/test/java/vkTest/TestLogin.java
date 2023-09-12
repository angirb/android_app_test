package vkTest;
import org.junit.BeforeClass;
import pageobjects.ServicesPage;
import utils.Helper;
import pageobjects.MainPage;
import pageobjects.VkPageMessage;
import utils.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static io.appium.java_client.android.nativekey.AndroidKey.HOME;
import static org.junit.Assert.assertEquals;

public class TestLogin extends BaseClass {


    // use Selenium native methods to test login
    @Test
    public void loginTest() throws InterruptedException {
        openVk();
        login();
    }
}
