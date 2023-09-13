package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.BaseClass;

import java.net.MalformedURLException;

public class TestPersonalPage extends BaseClass {

    @Before
    public void openApp() {
        openVk();
    }

    @Test
    public void testPublishFromPersonalPage() throws InterruptedException {
        createPost();
    }

    @Test
    public void testPublishPostTakePhoto() throws InterruptedException {
        createPostWithPicture();
    }

    @After
    public void closeApp() throws InterruptedException {
        tearDown();
    }
}
