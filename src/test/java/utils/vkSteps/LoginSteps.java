package utils.vkSteps;

import vkTest.BaseTestVk;
import utils.Driver;

public class LoginSteps extends Driver {

    public static void login() throws InterruptedException {
        BaseTestVk.openVk();
        watcher.processPopupIfNeeded(); // click accept window pop up notification
        watcher.systemPopupNotification(); // click system window pop up notification
        mainPage.writeEmail(); // input email
        mainPage.clickLoginBtn(); // click proceed
        mainPage.writePassword(); // input password
        mainPage.clickConfirmBtnPass(); // click confirm
        Thread.sleep(1000); // wait page to load


    }
}
