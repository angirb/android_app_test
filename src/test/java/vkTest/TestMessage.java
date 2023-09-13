package vkTest;

import utils.BaseClass;
import utils.vkSteps.MessageSteps;

import org.junit.*;



public class TestMessage extends BaseClass {
    protected MessageSteps messageSteps;
    @Before
    public void openApp() {
        openVk();
    }

    @Test
    public void sendMsgTest() throws InterruptedException {
       MessageSteps.sendMsg(); // send a message to a user
    }

    @Test
    public void sendSongInMsg() throws InterruptedException {
        MessageSteps.sendMusicInMsg();

    }

    @Test
    public void sendGeoLocationMsg() throws InterruptedException {
        MessageSteps.sendGeoLocationInMsg();
    }

    @After
    public void closeApp() throws InterruptedException {
        tearDown();
    }
}
