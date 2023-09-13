package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import utils.BaseClass;
import java.net.MalformedURLException;

public class TestMainPage extends BaseClass {

    @Before
    public void openApp() {
        openVk();
    }

    @Test
    public void testLikeBtn() {
        clickLikeBtn();
    }

    @Test
    public void testForYouPage() {
        forYouPage();
    }

    @Test
    public void testNewsPage()  {
        newsPage();
    }

    @Test
    public void testMainPagePostBtn() throws InterruptedException {
        mainPagePostBtn();
    }

    @After
    public void closeApp() throws InterruptedException {
        tearDown();
    }

}
