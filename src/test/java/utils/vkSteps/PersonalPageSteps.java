package utils.vkSteps;

import utils.Driver;

public class PersonalPageSteps extends Driver {

    public static void createPost() throws InterruptedException {
        personalPage.clickPersonalPage(); // click on Personal Page on Picture
        personalPage.clickPublishBtn(); // click Publish Button on Personal Page
        personalPage.clickCreatePostBtn(); // click create Post (text)
        personalPage.inputPostText(); // input text with random generator
        personalPage.clickPostBtn(); // click create post
        Thread.sleep(1000);
        personalPage.isPostPublished(); // check if popup message appeared
    }
    public static void createPostWithPicture() throws InterruptedException {

        personalPage.clickPersonalPage(); // click on Personal Page on Picture
        personalPage.clickPublishBtn(); // click Publish Button on Personal Page
        personalPage.clickCreatePhotoPost(); // click on Button Post with Photo

        watcher.processPopupIfNeeded(); // click agree button
        watcher.systemPopupNotification(); // click system agree button

        personalPage.clickTakePhoto(); // click on Take Photo button

        watcher.processPopupIfNeeded(); // click agree button
        watcher.systemPopupNotification(); // click system agree button
        watcher.systemPopupWhenUsingNotificationConfirm(); // click system agree button
        watcher.systemPopupWhenUsingNotificationConfirm(); // click system agree button
        mainPage.clickCameraBtnFromPersonalPage(); // take a picture
        mainPage.clickConfirmTakenPhoto(); // confirm picture
        mainPage.clickEditorPostRdyBtn(); // click Rdy "Готово" on right top corner
        personalPage.clickPostBtn(); // click on Publish button on right top corner
        Thread.sleep(1000);
        personalPage.isPostPublished(); // confirm if post was published

    }
}
