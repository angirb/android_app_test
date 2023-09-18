package vkTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.vkSteps.PersonalPageSteps;

public class TestPersonalPage extends BaseTestVk {

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
