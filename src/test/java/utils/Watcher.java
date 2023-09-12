package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jdk.tools.jmod.Main;
import pageobjects.MainPage;

// This class is to identify popup windows notifications where system is asking to confirm and allow app to use certain phone functions
public class Watcher {
    private AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;


    public Watcher(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // method to identify vk popup window and accept it
    public void processPopupIfNeeded() {
        MainPage mainPage = new MainPage(driver);

        try { // here i use try and if, so if the window appears we click confirm
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/action_bar_root")));

            if (popup.isDisplayed()) {
                mainPage.clickAccessBtn();
            }
        } catch (Exception e) {
            // Popup element not found or not displayed, continue with the flow
        }
    }

    // method to identify system popup window and accept it ПРИ ИСПОЛЬЗОВАНИИ
    public void systemPopupNotification() {
        MainPage mainPage = new MainPage(driver);
        try { // here i use try and if, so if the window appears we click confirm
            WebElement popupNotificationAccessWatcher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_message")));

            if (popupNotificationAccessWatcher.isDisplayed()) {
                mainPage.clickAcceptNotificationPopUpAccessBtn();
            }
        } catch (Exception e) {
        } // Popup element not found or not displayed, continue with the flow
    }

    // method to identify system popup window and accept it
    public void systemPopupWhenUsingNotificationConfirm() {
        MainPage mainPage = new MainPage(driver);
        try { // here i use try and if, so if the window appears we click confirm
            WebElement popupNotificationAccessWatcher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_message")));

            if (popupNotificationAccessWatcher.isDisplayed()) {
                mainPage.clickConfirmWhenUsingApp();
            }
        } catch (Exception e) {
        } // Popup element not found or not displayed, continue with the flow
    }
}
