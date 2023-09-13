package utils.vkSteps;

import static io.appium.java_client.android.nativekey.AndroidKey.HOME;

import io.appium.java_client.android.nativekey.KeyEvent;
import utils.Driver;

public class LogoutSteps extends Driver {
    public static void logOut() {
        servicesPage.clickServicesPage(); // open Services Page
        servicesPage.clickTopRightMenuBtn(); // open Settings Icon
        servicesPage.clickServicesPageSettingsBtn(); // open settings button
        servicesPage.clickAppSettingsBtn(); // click app settings
        servicesPage.scrollAndClick("Очистить всё и выйти"); // scroll, search and click clear ALL and EXIT
        mainPage.clickAccessBtn(); // click accept
        driver.pressKey(new KeyEvent(HOME)); // press go Home Button
    }
}
