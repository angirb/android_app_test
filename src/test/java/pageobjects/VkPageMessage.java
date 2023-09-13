package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.RandomTextGen;

import java.net.MalformedURLException;

public class VkPageMessage extends Helper {

    public VkPageMessage(AndroidDriver<AndroidElement> driver)  {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Мессенджер\" and @resource-id=\"com.vkontakte.android:id/navigation_bar_item_small_label_view\"]")
    public AndroidElement vkMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Альберт Курнев\" and @package=\"com.vkontakte.android\"]")
    public AndroidElement vkMessageAlbKur;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Альберт Курнев\" and @resource-id=\"com.vkontakte.android:id/vkim_title_text\"]")
    public AndroidElement vkMessageAlbKurTitle;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Сообщение\" and @resource-id=\"com.vkontakte.android:id/writebar_edit\"]")
    public AndroidElement vkMessageWriteBar;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Отправить\" and @resource-id=\"com.vkontakte.android:id/writebar_send\"]")
    public AndroidElement vkMessageSendButton;

    @AndroidFindBy(id = "com.vkontakte.android:id/messages_list_container")
    public AndroidElement vkMessageSentText;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Закрыть экран\"]")
    public AndroidElement goBackArrow;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Место\" and @resource-id=\"com.vkontakte.android:id/tv_title\"]")
    public AndroidElement geoLocationButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Текущее местоположение\" and @resource-id=\"com.vkontakte.android:id/vkim_location_title\"]")
    public AndroidElement sendCurrentGeoLocationButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Прикрепить вложение\"]")
    public AndroidElement attachFileButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Музыка\" and @resource-id=\"com.vkontakte.android:id/tv_title\"]")
    public AndroidElement attachMusicButton;

    @AndroidFindBy(id = "com.vkontakte.android:id/audio_artist")
    public AndroidElement selectSongById;
    @AndroidFindBy(id = "com.vkontakte.android:id/attach_counter_title_text_view")
    public AndroidElement attachSongToMsg;


    public void clickVkMessage() {
        clickElement(vkMessage);
    }
    public void clickVkMessageAlbKur() {
        clickElement(vkMessageAlbKur);
    }
    public void checkVkMessageAlbKurTitle() {
        isDisplayed(vkMessageAlbKurTitle);
    }
    public void clickWriteBar() {
        clickElement(vkMessageWriteBar);
    }
    public void inputMsgWriteBar() {
        sendKeysElement(vkMessageWriteBar, RandomTextGen.generateEngString());
    }
    public void clickVkMessageSendButton() {
        vkMessageSendButton.click();
    }
    public void clickGoBackArrow() {
        clickElement(goBackArrow);
    }
    public void clickSendGeoLocation() {
        clickElement(geoLocationButton);
    }
    public void clickAttachBtn() {
        clickElement(attachFileButton);
    }
    public void clickSendCurrentGeo() {
        clickElement(sendCurrentGeoLocationButton);
    }
    public void clickAttachMusicBtn() {
        clickElement(attachMusicButton);
    }
    public void setSelectSongById() {
        clickElement(selectSongById);
    }
    public void clickAttachSong() {
        clickElement(attachSongToMsg);
    }

}
