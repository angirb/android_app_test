package utils.vkSteps;

import utils.Driver;

public class MainPageSteps extends Driver {


    public static void clickLikeBtn() {
        mainPage.scrollToLikeBtn(); // scroll to any like button on main page
        mainPage.clickLikeBtn(); // click on first like icon
        mainPage.likeBtnIsClicked(); // check if like button was clicked
    }

    public static void forYouPage() {
        mainPage.clickForYouPageBtn(); // click for you page from main page
        mainPage.forYouPageIsDisplayed(); // check if for you page is displayed
    }

    public static void newsPage()  {
        mainPage.clickNewsPage(); // click news page from main page
        mainPage.newsTitleIsDisplayed(); // check if news title is displayed
    }
    public static void mainPagePostBtn() throws InterruptedException {
        mainPage.clickMainPagePostBtn(); // click create post button
        mainPage.storyBtnIsDisplayed(); // check if button "история" is displayed
        mainPage.clickCreateTextPost(); // click create Post (text)
        personalPage.inputPostText(); // input text with random generator
        personalPage.clickPostBtn(); // click create post
        Thread.sleep(1000);
        personalPage.isPostPublished(); // check if popup message appeared
    }
}
