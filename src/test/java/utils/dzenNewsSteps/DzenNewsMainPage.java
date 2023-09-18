package utils.dzenNewsSteps;


import static io.appium.java_client.android.nativekey.AndroidKey.BACK;

import io.appium.java_client.android.nativekey.KeyEvent;
import utils.Driver;

public class DzenNewsMainPage extends Driver {

    public static void mainPage() {
        dzenNewsPageObjects.dzenTitleDisplayed();
    }

    public static void politicsTitle() {
        dzenNewsPageObjects.scrollToPoliticsTitle();
        dzenNewsPageObjects.checkCategoryPoliticsTitle();
    }

    public static void sportTitle() {
        dzenNewsPageObjects.scrollToPhotoTitle();
        dzenNewsPageObjects.checkCategorySportTitle();
    }

    public static void addToBookMarks() {
        dzenNewsPageObjects.scrollToPoliticsTitle();
        dzenNewsPageObjects.clickBigPictureArticle();
        dzenNewsPageObjects.clickAddToBookMarks();
        dzenNewsPageObjects.isAddedToBookMarksMsg();
    }

    public static void checkWeather() {
        dzenNewsPageObjects.clickWeatherBtn();
        dzenNewsPageObjects.setGetWeatherTextTitle();
    }

    public static void checkNavigationMenuContainerTitle() {
        dzenNewsPageObjects.clickNavigationBtn();
        dzenNewsPageObjects.getNavigationMenuContainer();
        dzenNewsPageObjects.getNavigationMenuContainerMyRegion();
    }

    public static void deleteBookMarks() {
        dzenNewsPageObjects.scrollToPoliticsTitle();
        dzenNewsPageObjects.clickBigPictureArticle();
        dzenNewsPageObjects.clickAddToBookMarks();
        driver.pressKey(new KeyEvent(BACK));
        dzenNewsPageObjects.clickBookMarksBtn();
        dzenNewsPageObjects.clickEditBtnBookMarks();
        dzenNewsPageObjects.setSelectBookMarks();
        dzenNewsPageObjects.clickDeleteBookMarks();
        dzenNewsPageObjects.isBookMarkDeleted();
    }
}
