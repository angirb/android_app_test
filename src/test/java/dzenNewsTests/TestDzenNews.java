package dzenNewsTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.dzenNewsSteps.DzenNewsMainPage;

public class TestDzenNews extends BaseTestDzen {

    @Before
    public void openDzen() {
        openDzenNewsApp();
    }


    @Test
    public void testPicOfADayIsVisible() {
        DzenNewsMainPage.mainPage();
    }

    @Test
    public void testPoliticsTitleIsDisplayed() {
        DzenNewsMainPage.politicsTitle();

    }

    @Test
    public void testSportTitleCategory() {
        DzenNewsMainPage.sportTitle();
    }

    @Test
    public void testAddToBookMarks() throws InterruptedException {
        DzenNewsMainPage.addToBookMarks();
    }

    @Test
    public void checkWeather() {
        DzenNewsMainPage.checkWeather();
    }

    @Test
    public void checkNavigationMenuContainerTittle() {
        DzenNewsMainPage.checkNavigationMenuContainerTitle();
    }

    @Test
    public void addAndDeleteBookMark() {
        DzenNewsMainPage.deleteBookMarks();
    }


    @After
    public void closeDzenNews() throws InterruptedException {
        closeDzenNewsApp();
    }

}
