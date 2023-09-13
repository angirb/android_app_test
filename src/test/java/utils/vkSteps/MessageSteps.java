package utils.vkSteps;

import utils.Driver;

public class MessageSteps extends Driver {

    public static void sendMsg() throws InterruptedException {
        vkPageMessage.clickVkMessage(); // click Message section from Main page
        vkPageMessage.clickVkMessageAlbKur(); // click Albert Kurnev
        vkPageMessage.clickWriteBar(); // click on write bar to type a message
        vkPageMessage.inputMsgWriteBar(); // input text with random generator
        vkPageMessage.clickVkMessageSendButton(); // click send message
        vkPageMessage.clickGoBackArrow(); // click go back arrow to return on main page
        Thread.sleep(2000);
    }

    public static void sendMusicInMsg() throws InterruptedException {
        vkPageMessage.clickVkMessage();
        vkPageMessage.clickVkMessageAlbKur();
        vkPageMessage.clickAttachBtn();
        Thread.sleep(2000);
        vkPageMessage.clickAttachMusicBtn();
        vkPageMessage.setSelectSongById();
        vkPageMessage.clickAttachSong();
        vkPageMessage.clickVkMessageSendButton();
        vkPageMessage.clickGoBackArrow();
        Thread.sleep(2000);
    }

    public static void sendGeoLocationInMsg() throws InterruptedException {
        vkPageMessage.clickVkMessage();
        vkPageMessage.clickVkMessageAlbKur();
        vkPageMessage.clickAttachBtn();
        Thread.sleep(2000);
        watcher.processPopupIfNeeded(); // use method to click access buttons
        watcher.systemPopupNotification();
        vkPageMessage.scrollHorizontallyAndClick("Место");

        vkPageMessage.clickSendGeoLocation(); // click geolocation button
        watcher.processPopupIfNeeded();
        watcher.systemPopupNotification();
        watcher.systemPopupWhenUsingNotificationConfirm();
        vkPageMessage.clickSendCurrentGeo(); // click current geo
        vkPageMessage.clickVkMessageSendButton();
        vkPageMessage.clickGoBackArrow();
    }
}
