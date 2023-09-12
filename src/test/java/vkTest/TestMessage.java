package vkTest;

import pageobjects.MainPage;
import pageobjects.VkPageMessage;
import utils.BaseClass;
import utils.Helper;
import utils.RandomTextGen;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.junit.*;

import static io.appium.java_client.android.nativekey.AndroidKey.HOME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;

public class TestMessage extends BaseClass {
    @Before
    public void openApp() {
        openVk();
    }

    @Test
    public void sendMsgTest() {
        sendMsg(); // send a message to a user
    }

    @Test
    public void sendSongInMsg() throws InterruptedException {
        sendMusicInMsg();

    }

    @Test
    public void sendGeoLocationMsg() throws InterruptedException {
        sendGeoLocationInMsg();
    }
    @After
    public void closeApp() throws InterruptedException {
        tearDown();
    }
}
