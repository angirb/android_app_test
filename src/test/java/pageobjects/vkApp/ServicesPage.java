package pageobjects.vkApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import utils.Helper;

public class ServicesPage extends Helper {
    public ServicesPage(AndroidDriver<AndroidElement> driver)  {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Сервисы\"]/android.widget.FrameLayout[2]/android.widget.ImageView")
    public AndroidElement servicesPage;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Открыть меню\"]")
    public AndroidElement topRightMenuButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Настройки\" and @resource-id=\"com.vkontakte.android:id/title\"]")
    public AndroidElement servicesPageSettingsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Приложение\" and @resource-id=\"android:id/text1\"]")
    public AndroidElement appSettingsBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Очистить всё и выйти\" and @resource-id=\"android:id/title\"]")
    public AndroidElement clearAllAndExitApp;


    public void clickServicesPage() {
        clickElement(servicesPage);
    }
    public void clickTopRightMenuBtn() {
        clickElement(topRightMenuButton);
    }
    public void clickServicesPageSettingsBtn() {
        clickElement(servicesPageSettingsButton);
    }
    public void clickAppSettingsBtn() {
        clickElement(appSettingsBtn);
    }
    public void clickClearAllAndExitApp() {
        clickElement(clearAllAndExitApp);
    }

}
