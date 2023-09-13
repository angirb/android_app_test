package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import utils.BaseClass;
import utils.vkSteps.MainPageSteps;

import java.net.MalformedURLException;

public class TestMainPage extends BaseClass {

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
