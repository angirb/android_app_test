package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.BaseClass;

import java.net.MalformedURLException;

public class TestPersonalPage extends BaseClass {

    @Before
    public void openApp() throws MalformedURLException {
        openVk();
    }

    @Test
    public void testPublishFromPersonalPage() throws MalformedURLException, InterruptedException {
        createPost();
    }

    @Test
    public void testPublishPostTakePhoto() throws MalformedURLException, InterruptedException {
        createPostWithPicture();
    }

    @After
    public void closeApp() throws MalformedURLException, InterruptedException {
        tearDown();
    }
}
