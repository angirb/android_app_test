package utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobjects.MainPage;
import pageobjects.PersonalPage;
import pageobjects.ServicesPage;
import pageobjects.VkPageMessage;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.android.nativekey.AndroidKey.BACK;
import static io.appium.java_client.android.nativekey.AndroidKey.HOME;

public class BaseClass extends Driver {

    @BeforeClass
    public static void beforeClass() throws MalformedURLException, InterruptedException {
        setUp(); // use set up methods
        login(); // before starting the test login into account
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


    protected static void openVk() {
        helper.swipeUp(driver, 500); // swipe up on main screen to open all apps menu
        mainPage.clickVkApp(); // search for VK app, if cant be found it will scroll down until it finds and clicks
    }

    protected static void login() throws InterruptedException {
        openVk(); // open VK app from all apps menu
        mainPage.writeEmail(); // input email
        mainPage.clickLoginBtn(); // click proceed
        mainPage.writePassword(); // input password
        mainPage.clickConfirmBtnPass(); // click confirm
        Thread.sleep(1000); // wait page to load
        watcher.processPopupIfNeeded(); // click accept window pop up notification
        watcher.systemPopupNotification(); // click system window pop up notification
        Thread.sleep(2000); // wait

    }
    protected static void logOut() {
        servicesPage.clickServicesPage(); // open Services Page
        servicesPage.clickTopRightMenuBtn(); // open Settings Icon
        servicesPage.clickServicesPageSettingsBtn(); // open settings button
        servicesPage.clickAppSettingsBtn(); // click app settings
        servicesPage.scrollAndClick("Очистить всё и выйти"); // scroll, search and click clear ALL and EXIT
        mainPage.clickAccessBtn(); // click accept
        driver.pressKey(new KeyEvent(HOME)); // press go Home Button
    }

    protected void sendMsg() throws InterruptedException {
        vkPageMessage.clickVkMessage(); // click Message section from Main page
        vkPageMessage.clickVkMessageAlbKur(); // click Albert Kurnev
        vkPageMessage.clickWriteBar(); // click on write bar to type a message
        vkPageMessage.inputMsgWriteBar(); // input text with random generator
        vkPageMessage.clickVkMessageSendButton(); // click send message
        vkPageMessage.clickGoBackArrow(); // click go back arrow to return on main page
        Thread.sleep(2000);
    }

    protected void sendMusicInMsg() throws InterruptedException {
        vkPageMessage.clickVkMessage();
        vkPageMessage.clickVkMessageAlbKur();
        vkPageMessage.clickAttachBtn();
        Thread.sleep(2000);
        vkPageMessage.clickAttachMusicBtn();
        vkPageMessage.setSelectSongById();
        vkPageMessage.clickAttachSong();
        vkPageMessage.clickVkMessageSendButton();
        vkPageMessage.clickGoBackArrow();
        Thread.sleep(2000);
    }

    protected void sendGeoLocationInMsg() throws InterruptedException {
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

    protected void tearDown() throws InterruptedException {
        driver.pressKey(new KeyEvent(HOME));
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Thread.sleep(1000);
        helper.isDisplayed(mainPage.clearAllTasks);
        helper.clickElement(mainPage.clearAllTasks);
    }

    protected void clickLikeBtn() {
        mainPage.scrollToLikeBtn(); // scroll to any like button on main page
        mainPage.clickLikeBtn(); // click on first like icon
        mainPage.likeBtnIsClicked(); // check if like button was clicked
    }

    protected void forYouPage() {
        mainPage.clickForYouPageBtn(); // click for you page from main page
        mainPage.forYouPageIsDisplayed(); // check if for you page is displayed
    }

    protected void newsPage()  {
        mainPage.clickNewsPage(); // click news page from main page
        mainPage.newsTitleIsDisplayed(); // check if news title is displayed
    }
    protected void mainPagePostBtn() throws InterruptedException {
        mainPage.clickMainPagePostBtn(); // click create post button
        mainPage.storyBtnIsDisplayed(); // check if button "история" is displayed
        mainPage.clickCreateTextPost(); // click create Post (text)
        personalPage.inputPostText(); // input text with random generator
        personalPage.clickPostBtn(); // click create post
        Thread.sleep(1000);
        personalPage.isPostPublished(); // check if popup message appeared
    }

    protected void createPost() throws InterruptedException {
        personalPage.clickPersonalPage(); // click on Personal Page on Picture
        personalPage.clickPublishBtn(); // click Publish Button on Personal Page
        personalPage.clickCreatePostBtn(); // click create Post (text)
        personalPage.inputPostText(); // input text with random generator
        personalPage.clickPostBtn(); // click create post
        Thread.sleep(1000);
        personalPage.isPostPublished(); // check if popup message appeared
    }
    protected void createPostWithPicture() throws InterruptedException {

        personalPage.clickPersonalPage(); // click on Personal Page on Picture
        personalPage.clickPublishBtn(); // click Publish Button on Personal Page
        personalPage.clickCreatePhotoPost(); // click on Button Post with Photo

        watcher.processPopupIfNeeded(); // click agree button
        watcher.systemPopupNotification(); // click system agree button

        personalPage.clickTakePhoto(); // click on Take Photo button

        watcher.processPopupIfNeeded(); // click agree button
        watcher.systemPopupNotification(); // click system agree button
        watcher.systemPopupWhenUsingNotificationConfirm(); // click system agree button
        watcher.systemPopupWhenUsingNotificationConfirm(); // click system agree button
        mainPage.clickCameraBtnFromPersonalPage(); // take a picture
        mainPage.clickConfirmTakenPhoto(); // confirm picture
        mainPage.clickEditorPostRdyBtn(); // click Rdy "Готово" on right top corner
        personalPage.clickPostBtn(); // click on Publish button on right top corner
        Thread.sleep(1000);
        personalPage.isPostPublished(); // confirm if post was published

    }
}
