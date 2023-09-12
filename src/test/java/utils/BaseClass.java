package utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobjects.MainPage;
import pageobjects.PersonalPage;
import pageobjects.ServicesPage;
import pageobjects.VkPageMessage;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.android.nativekey.AndroidKey.HOME;

public class BaseClass {
    // create objects
    protected static AndroidDriver<AndroidElement> driver;
    protected MainPage mainPage;
    protected Helper helper;
    protected Watcher watcher;
    protected ServicesPage servicesPage;
    protected VkPageMessage vkPageMessage;
    protected PersonalPage personalPage;


    @Before
    public void setUp() throws MalformedURLException {
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

    }



    public void openVk() {
        helper.swipeUp(driver, 500);
        mainPage.clickVkApp();
    }

    public void login() throws InterruptedException {
        mainPage.writeEmail();
        mainPage.clickLoginBtn();
        mainPage.writePassword();
        mainPage.clickConfirmBtnPass();
        Thread.sleep(1000);
        watcher.processPopupIfNeeded();
        watcher.systemPopupNotification();

    }
    public void logOut() {
        servicesPage.clickServicesPage();
        servicesPage.clickTopRightMenuBtn();
        servicesPage.clickServicesPageSettingsBtn();
        servicesPage.clickAppSettingsBtn();
        servicesPage.scrollAndClick("Очистить всё и выйти");
        mainPage.clickAccessBtn();
    }

    public void sendMsg() {

        vkPageMessage.clickVkMessage(); // click Message section from Main page
        vkPageMessage.clickVkMessageAlbKur(); // click Albert Kurnev
        vkPageMessage.clickWriteBar(); // click on write bar to type a message
        vkPageMessage.inputMsgWriteBar(); // input text with random generator
        vkPageMessage.clickVkMessageSendButton(); // click send message
        vkPageMessage.clickGoBackArrow(); // click go back arrow to return on main page
    }

    public void sendMusicInMsg() throws InterruptedException {

        vkPageMessage.clickVkMessage();
        vkPageMessage.clickVkMessageAlbKur();
        vkPageMessage.clickAttachBtn();

        Thread.sleep(2000);
        vkPageMessage.clickAttachMusicBtn();
        vkPageMessage.setSelectSongById();
        vkPageMessage.clickAttachSong();
        vkPageMessage.clickVkMessageSendButton();
        vkPageMessage.clickGoBackArrow();
    }

    public void sendGeoLocationInMsg() throws InterruptedException {

        vkPageMessage.clickVkMessage();
        vkPageMessage.clickVkMessageAlbKur();
        vkPageMessage.clickAttachBtn();
        Thread.sleep(2000);
        watcher.processPopupIfNeeded(); // use method to click access buttons
        watcher.systemPopupNotification();
        vkPageMessage.scrollHorizontallyAndClick("Место");

        vkPageMessage.clickSendGeoLocation(); // click geolocation button
        watcher.processPopupIfNeeded();
        watcher.systemPopupNotification();
        watcher.systemPopupWhenUsingNotificationConfirm();
        vkPageMessage.clickSendCurrentGeo(); // click current geo
        vkPageMessage.clickVkMessageSendButton();
        vkPageMessage.clickGoBackArrow();

    }

    public void tearDown() throws InterruptedException {

        driver.pressKey(new KeyEvent(HOME));
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Thread.sleep(2000);
        helper.isDisplayed(mainPage.clearAllTasks);
        helper.clickElement(mainPage.clearAllTasks);
    }

    public void clickLikeBtn() {

        mainPage.scrollToLikeBtn(); // scroll to any like button on main page
        mainPage.clickLikeBtn(); // click on first like icon
        mainPage.likeBtnIsClicked(); // check if like button was clicked
    }

    public void forYouPage() {

        mainPage.clickForYouPageBtn(); // click for you page from main page
        mainPage.forYouPageIsDisplayed(); // check if for you page is displayed
    }

    public void newsPage()  {

        mainPage.clickNewsPage(); // click news page from main page
        mainPage.newsTitleIsDisplayed(); // check if news title is displayed
    }
    public void mainPagePostBtn() throws InterruptedException {

        mainPage.clickMainPagePostBtn(); // click create post button
        mainPage.storyBtnIsDisplayed(); // check if button "история" is displayed
        mainPage.clickCreateTextPost(); // click create Post (text)
        personalPage.inputPostText(); // input text with random generator
        personalPage.clickPostBtn(); // click create post
        Thread.sleep(1000);
        personalPage.isPostPublished(); // check if popup message appeared
    }

    public void createPost() throws InterruptedException {

        personalPage.clickPersonalPage(); // click on Personal Page on Picture
        personalPage.clickPublishBtn(); // click Publish Button on Personal Page
        personalPage.clickCreatePostBtn(); // click create Post (text)
        personalPage.inputPostText(); // input text with random generator
        personalPage.clickPostBtn(); // click create post
        Thread.sleep(1000);
        personalPage.isPostPublished(); // check if popup message appeared
    }
    public void createPostWithPicture() throws InterruptedException {

        personalPage.clickPersonalPage(); // click on Personal Page on Picture
        personalPage.clickPublishBtn(); // click Publish Button on Personal Page
        personalPage.clickCreatePhotoPost(); // click on Button Post with Photo

        watcher.processPopupIfNeeded(); // use method to click access buttons
        watcher.systemPopupNotification();

        personalPage.clickTakePhoto(); // click on Take Photo button

        watcher.processPopupIfNeeded();
        watcher.systemPopupNotification();
        watcher.systemPopupWhenUsingNotificationConfirm();

        mainPage.clickCameraBtnFromPersonalPage(); // take a picture
        mainPage.clickConfirmTakenPhoto(); // confirm picture
        mainPage.clickEditorPostRdyBtn(); // click Rdy "Готово" on right top corner
        personalPage.clickPostBtn(); // click on Publish button on right top corner
        Thread.sleep(1000);
        personalPage.isPostPublished(); // confirm if post was published

    }
}
