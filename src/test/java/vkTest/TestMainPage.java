package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageobjects.vkApp.BaseTestVk;
import utils.vkSteps.MainPageSteps;

public class TestMainPage extends BaseTestVk {

    @Before
    public void openApp() {
        openVk();
    }

    @Test
    public void testLikeBtn() {
        MainPageSteps.clickLikeBtn();
    }

    @Test
    public void testForYouPage() {
        MainPageSteps.forYouPage();
    }

    @Test
    public void testNewsPage()  {
        MainPageSteps.newsPage();
    }

    @Test
    public void testMainPagePostBtn() throws InterruptedException {
        MainPageSteps.mainPagePostBtn();
    }

    @After
    public void closeApp() throws InterruptedException {
        tearDown();
    }

}
