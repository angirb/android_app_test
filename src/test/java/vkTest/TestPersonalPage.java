package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageobjects.vkApp.PersonalPage;
import utils.BaseClass;
import utils.vkSteps.PersonalPageSteps;

import java.net.MalformedURLException;

public class TestPersonalPage extends BaseClass {

    @Before
    public void openApp() {
        openVk();
    }

    @Test
    public void testPublishFromPersonalPage() throws InterruptedException {
        PersonalPageSteps.createPost();
    }

    @Test
    public void testPublishPostTakePhoto() throws InterruptedException {
        PersonalPageSteps.createPostWithPicture();
    }

    @After
    public void closeApp() throws InterruptedException {
        tearDown();
    }
}
