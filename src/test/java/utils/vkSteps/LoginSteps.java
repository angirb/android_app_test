package utils.vkSteps;

import utils.BaseClass;
import utils.Driver;

public class LoginSteps extends Driver {

    public static void login() throws InterruptedException {
        BaseClass.openVk();
        watcher.processPopupIfNeeded(); // click accept window pop up notification
        watcher.systemPopupNotification(); // click system window pop up notification
        mainPage.writeEmail(); // input email
        mainPage.clickLoginBtn(); // click proceed
        mainPage.writePassword(); // input password
        mainPage.clickConfirmBtnPass(); // click confirm
        Thread.sleep(1000); // wait page to load


    }
}
