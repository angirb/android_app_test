package pageobjects.dzenNews;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Helper;

public class DzenNewsPageObjects extends Helper {


    public DzenNewsPageObjects(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Новости\"]")
    AndroidElement dzenNewsApp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Разрешить\"]")
    AndroidElement allowBtn;

    //Categories
    @AndroidFindBy(id = "ru.mail.mailnews:id/mainTitle")
    AndroidElement dzenTitle;

    @AndroidFindBy(id = "ru.mail.mailnews:id/rubricText")
    AndroidElement newsCategoryTitles;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Политика\" and @resource-id=\"ru.mail.mailnews:id/rubricText\"]")
    AndroidElement categoryPolitics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Спорт\" and @resource-id=\"ru.mail.mailnews:id/rubricText\"]")
    AndroidElement categorySport;

    @AndroidFindBy(id = "ru.mail.mailnews:id/weatherInformer")
    AndroidElement weatherBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Мой регион\" and @resource-id=\"ru.mail.mailnews:id/headerText\"]")
    AndroidElement myRegionTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Политика\" and @resource-id=\"ru.mail.mailnews:id/headerText\"]")
    AndroidElement politicsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Спорт\" and @resource-id=\"ru.mail.mailnews:id/headerText\"]")
    AndroidElement sportTitle;

    //Article
    @AndroidFindBy(id = "ru.mail.mailnews:id/menu_web_add_bookmark")
    AndroidElement addNewsToBookmarks;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Избранное\"]")
    AndroidElement bookMarksBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"ru.mail.mailnews:id/emptyTitle\" and @text=\"Здесь пока пусто\"]")
    AndroidElement bookMarkIsEmpty;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"ru.mail.mailnews:id/selectButton\" and @text=\"Изменить\"]")
    AndroidElement editBookMarksBtn;
    
    @AndroidFindBy(id = "ru.mail.mailnews:id/actionIcon")
    AndroidElement selectBookMarks;

    @AndroidFindBy(id = "ru.mail.mailnews:id/deleteButton")
    AndroidElement deleteBookMarksBtn;

    @AndroidFindBy(id = "ru.mail.mailnews:id/menu_web_close")
    AndroidElement closeNewsArticle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"ru.mail.mailnews:id/text\" and @text=\"Добавлено в избранное\"]")
    AndroidElement addedToBookmarks;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"ru.mail.mailnews:id/text\" and @text=\"Статья удалена\"]")
    AndroidElement bookMarkIsDeleted;

    @AndroidFindBy(id = "ru.mail.mailnews:id/newsImageLarge")
    AndroidElement bigPictureNewsArticle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Прогноз погоды в Москве на сегодня - погода в Москве сейчас, прогноз на завтра и на ближайшие дни - Погода Mail.ru\"]")
    AndroidElement getWeatherTextTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@package=\"ru.mail.mailnews\"]")
    AndroidElement navigationMenuContainer;
    @AndroidFindBy(xpath = "//android.widget.TextView[@package=\"ru.mail.mailnews\" and @text=\"Мой регион\"]")
    AndroidElement navigationMenuContainerMyRegion;

    @AndroidFindBy(id = "ru.mail.mailnews:id/mainNavigationMenu")
    AndroidElement navigationMenuBtn;

    public void clickBookMarksBtn() {
        clickElement(bookMarksBtn);
    }
    public void clickEditBtnBookMarks() {
        clickElement(editBookMarksBtn);
    }
    public void setSelectBookMarks() {
        clickElement(selectBookMarks);
    }
    public void clickDeleteBookMarks() {
        clickElement(deleteBookMarksBtn);
    }

    public void isBookMarkDeleted() {
        Assert.assertEquals("Статья удалена", bookMarkIsDeleted.getText());
    }

    public void isAddedToBookMarksMsg() {
        Assert.assertEquals("Добавлено в избранное", addedToBookmarks.getText());
    }

    public void clickBigPictureArticle() {
        clickElement(bigPictureNewsArticle);
    }
    public void clickDzenNewsApp() {
        scrollAndClick("Новости");
    }

    public void clickAllowBtnFirstTimeOpen() {
        clickElement(allowBtn);
    }

    public void dzenTitleDisplayed() {
        Assert.assertTrue(isDisplayed(dzenTitle));
    }

    public void scrollToPoliticsTitle() {
        scrollHorizontallyAndClick("Политика");
    }

    public void scrollToPhotoTitle() {
        scrollHorizontallyAndClick("Спорт");
    }

    public void checkCategorySportTitle() {
        Assert.assertEquals("Спорт", getText(categorySport));
    }

    public void checkCategoryPoliticsTitle() {
       Assert.assertTrue(isDisplayed(categoryPolitics));
    }
    public void closeArticleBtn() {
        clickElement(closeNewsArticle);
    }
    public void clickAddToBookMarks() {
        clickElement(addNewsToBookmarks);
    }


    public void clickWeatherBtn() {
        isDisplayed(weatherBtn);
        clickElement(weatherBtn);
    }
    public void scrollToWeatherMore() {
        scrollAndClick("Показать ещё");
    }
    public void setGetWeatherTextTitle() {
        isDisplayed(getWeatherTextTitle);
        Assert.assertEquals("Прогноз погоды в Москве на сегодня - погода в Москве сейчас, прогноз на завтра и на ближайшие дни - Погода Mail.ru", getWeatherTextTitle.getText());
    }

    public void clickNavigationBtn() {
        clickElement(navigationMenuBtn);
    }

    public void getNavigationMenuContainer() {
        String navigationMenuCategoriesTitles = ("Картина дня");
        isDisplayed(navigationMenuContainer);
        Assert.assertEquals(navigationMenuCategoriesTitles, navigationMenuContainer.getText());

    }
    public void getNavigationMenuContainerMyRegion() {
        String navigationMenuCategoriesMyRegion = ("Мой регион");
        isDisplayed(navigationMenuContainerMyRegion);
        Assert.assertEquals(navigationMenuCategoriesMyRegion, navigationMenuContainerMyRegion.getText());

    }
}
