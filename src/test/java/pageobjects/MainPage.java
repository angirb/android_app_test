package pageobjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.Helper;

import java.net.MalformedURLException;
import java.sql.Driver;

public class MainPage extends Helper {
    String EMAIL = "dasdasd@gmail.com";
    String PASSWORD = "password";

    public MainPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    // vkApp
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"VK\"]")
    public AndroidElement vkApp;

    // clear all tasks button
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Clear all\" and @resource-id=\"com.transsion.hilauncher:id/ts_btn_recents_clear\"]")
    public AndroidElement clearAllTasks;

    @AndroidFindBy(xpath = "//android.widget.ListView[@content-desc=\"Нет последних элементов\"]")
    public AndroidElement noRecentApps;

    @AndroidFindBy(id = "com.transsion.hilauncher:id/apps_view_container")
    public AndroidElement allApps;

    // login vk page
    @AndroidFindBy(id = "com.vkontakte.android:id/email_or_phone")
    public AndroidElement emailField;

    @AndroidFindBy(id = "com.vkontakte.android:id/login_button")
    public AndroidElement loginBtn;

    @AndroidFindBy(id = "com.vkontakte.android:id/vk_password")
    public AndroidElement passwordField;

    @AndroidFindBy(id = "com.vkontakte.android:id/vk_loading_btn_end_icon")
    public AndroidElement confirmBtnPass;

    // push notification window and access button
    @AndroidFindBy(id = "com.vkontakte.android:id/action_bar_root")
    public AndroidElement pushNotificationWindow;

    @AndroidFindBy(id = "android:id/button1")
    public AndroidElement acceptBtn;

    @AndroidFindBy(id = "android:id/button2")
    public AndroidElement denyBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"ПРИ ИСПОЛЬЗОВАНИИ ПРИЛОЖЕНИЯ\" and @resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
    public AndroidElement whenUsingGAppPopUpMsg;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/grant_dialog")
    public AndroidElement notificationPopUpAccess;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public AndroidElement acceptNotificationPopUpAccessBtn;

    // like buttons
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Нравится\"]/android.view.ViewGroup")
    public AndroidElement likeBtnMainPage;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Убрать реакцию «Нравится»\"]/android.view.ViewGroup/android.widget.ImageView")
    public AndroidElement likeBtnClicked;

    @AndroidFindBy(id = "com.vkontakte.android:id/likes_wrapper")
    public AndroidElement likeBtnById;

    // Main page different sections News, suggestions, buttons
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Для вас\"]/android.widget.TextView")
    public AndroidElement forYouPageBtn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Новости\"]/android.widget.TextView")
    public AndroidElement newsPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Главная\" and @resource-id=\"com.vkontakte.android:id/title\"]")
    public AndroidElement mainPageTitleText;

    @AndroidFindBy(id = "com.vkontakte.android:id/appkit_loader_root")
    public AndroidElement forYouPageIsDisplayed;

    @AndroidFindBy(id = "com.vkontakte.android:id/news_dzen_header_container")
    public AndroidElement newsTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Создать\"]/android.widget.ImageView")
    public AndroidElement mainPagePostBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vkontakte.android:id/tv_type_title\" and @text=\"История\"]")
    public AndroidElement mainPagePostStoryBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Запись\"]")
    public AndroidElement mainPageCreateTextPost;

    // Camera buttons

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.transsion.camera:id/shutter_button\"]")
    public AndroidElement cameraBtn;

    @AndroidFindBy(id = "com.transsion.camera:id/done_button")
    public AndroidElement confirmTakenPhotoBtn;

    // edit post section

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vkontakte.android:id/button_editor_complete\" and @text=\"Готово\"]")
    public AndroidElement editorPostRdyButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Фотография\"]")
    public AndroidElement photoAddedToPostEditor;


    // Methods for tests using Helper class to use webDriver
    public void clickVkApp() {
        scrollAndClick("VK");
    }

    public void writeEmail() {
        emailField.sendKeys(EMAIL);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void writePassword() {
        passwordField.sendKeys(PASSWORD);
    }

    public void clickConfirmBtnPass() {
        confirmBtnPass.click();
    }

    public void setPushNotificationWindow() {
        isDisplayed(pushNotificationWindow);
    }

    public void clickAccessBtn() {
        clickElement(acceptBtn);
    }

    public void setNotificationPopUpAccess() {
        notificationPopUpAccess.isDisplayed();
    }

    public void clickAcceptNotificationPopUpAccessBtn() {
        clickElement(acceptNotificationPopUpAccessBtn);
    }

    public void scrollToLikeBtn() {
        scrollByID("com.vkontakte.android:id/likes_wrapper", 0);
    }

    public void clickLikeBtn() {
        waitForVisibilityOf(likeBtnMainPage);
        clickElement(likeBtnMainPage);
    }

    public void likeBtnIsClicked() {
        Assert.assertTrue(likeBtnClicked.isDisplayed());
    }

    public void clickForYouPageBtn() {
        clickElement(forYouPageBtn);
    }

    public void forYouPageIsDisplayed() {
        Assert.assertTrue(forYouPageIsDisplayed.isDisplayed());
    }

    public void clickNewsPage() {
        clickElement(newsPage);
        waitForVisibilityOf(newsTitle);
    }

    public void newsTitleIsDisplayed() {
        Assert.assertTrue(newsTitle.isDisplayed());
    }

    public void clickMainPagePostBtn() {
        clickElement(mainPagePostBtn);
    }

    public void storyBtnIsDisplayed() {
        Assert.assertTrue(mainPagePostStoryBtn.isDisplayed());
    }

    public void clickCameraBtnFromPersonalPage() {
        clickElement(cameraBtn);
    }

    public void clickConfirmTakenPhoto() {
        clickElement(confirmTakenPhotoBtn);
    }

    public void clickEditorPostRdyBtn() {
        clickElement(editorPostRdyButton);
    }

    public void confirmPhotoAddedToPostEditor() {
        Assert.assertTrue(photoAddedToPostEditor.isDisplayed());
    }

    public void clickConfirmWhenUsingApp() {
        clickElement(whenUsingGAppPopUpMsg);
    }
    public void clickCreateTextPost() {
        clickElement(mainPageCreateTextPost);
    }

}
