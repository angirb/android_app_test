package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.BaseClass;
import java.net.MalformedURLException;

public class TestMainPage extends BaseClass {

    @Before
    public void openApp() {
        openVk();
    }

    @Test
    public void testLikeBtn() throws MalformedURLException {
        clickLikeBtn();
    }

    @Test
    public void testForYouPage() throws MalformedURLException {
        forYouPage();
    }

    @Test
    public void testNewsPage() throws MalformedURLException {
        newsPage();
    }

    @Test
    public void testMainPagePostBtn() throws MalformedURLException, InterruptedException {
        mainPagePostBtn();
    }

    @After
    public void closeApp() throws MalformedURLException, InterruptedException {
        tearDown();
    }

}
