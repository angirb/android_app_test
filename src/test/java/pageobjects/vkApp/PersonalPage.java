package pageobjects.vkApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import utils.Helper;
import utils.RandomTextGen;

public class PersonalPage extends Helper {

    public PersonalPage(AndroidDriver<AndroidElement> driver)  {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Открыть меню\"]")
    public AndroidElement userPersonalPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Опубликовать\" and @resource-id=\"com.vkontakte.android:id/tv_primary_action\"]")
    public AndroidElement personalPagePublishBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Запись\" and @resource-id=\"com.vkontakte.android:id/create_post\"]")
    public AndroidElement createPostBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Что у вас нового?\" and @resource-id=\"com.vkontakte.android:id/posting_edit_text\"]")
    public AndroidElement inputPostField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Опубликовать\" and @resource-id=\"com.vkontakte.android:id/btn_done\"]")
    public AndroidElement postBtn;
    @AndroidFindBy(xpath = "//android.widget.Toast[@package='com.android.settings' and @class='android.widget.Toast' and @text='Запись опубликована']")
    public AndroidElement postPublishedPopUp;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Фото\" and @resource-id=\"com.vkontakte.android:id/create_photo_post\"]")
    public AndroidElement createPhotoPost;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Фото\" and @resource-id=\"com.vkontakte.android:id/picker_attach_gallery_photo_text_view\"]")
    public AndroidElement takePhoto;

    public void clickPersonalPage() {
        clickElement(userPersonalPage);
    }
    public void clickPublishBtn() {
        clickElement(personalPagePublishBtn);
    }
    public void clickCreatePostBtn() {
        clickElement(createPostBtn);
    }
    public void inputPostText() {
        sendKeysElement(inputPostField, RandomTextGen.generateRuString());
    }
    public void clickPostBtn() {
        clickElement(postBtn);
    }
    public void isPostPublished() {
        Assert.assertEquals("Запись опубликована", postPublishedPopUp.getText());
    }
    public void clickCreatePhotoPost() {
        clickElement(createPhotoPost);
    }
    public void clickTakePhoto() {
        clickElement(takePhoto);
    }

}
