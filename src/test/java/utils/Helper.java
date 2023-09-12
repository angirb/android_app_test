package utils;

import static java.time.Duration.ofMillis;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;

public class Helper {
    protected AndroidDriver<AndroidElement> driver;
    protected WebDriverWait wait;

    public Helper(AndroidDriver<AndroidElement> driver)  {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);

    }



    public void swipeUp(AndroidDriver driver, int duration) {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = size.height * 7/8;
        int endX = startX;
        int endY = size.height / 8;

        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(duration)))
                .moveTo(point(endX, endY))
                .release()
                .perform();
    }


    public String getText(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public Boolean isDisplayed(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
    public void waitForElementIsInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void waitForVisibilityOfElementLocated(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForVisibilityOf(AndroidElement by) {
        wait.until(ExpectedConditions.visibilityOf(by));
    }
    public void mouseOver(By by) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(by)).build().perform();
    }
    public void dragAndDrop(By From, By To) {
        AndroidElement Drag = (AndroidElement) driver.findElement(From);
        AndroidElement Drop = (AndroidElement) driver.findElement(To);

        Actions act = new Actions(driver);
        act.dragAndDrop(Drag, Drop).build().perform();
    }
    public int[] getUniqueNumber(int arraySize, int max) {
        return ThreadLocalRandom.current().ints(1, max).distinct().limit(arraySize).toArray();
    }

    public void scrollByID(String Id, int index) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+Id+"\").instance("+index+"));"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollAndClick(String selector) {
        String locator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + selector + "\").instance(0))";
        driver.findElementByAndroidUIAutomator(locator).click();
    }
    public void scrollHorizontallyAndClick(String selector) {
        String locator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"" + selector + "\").instance(0))";
        driver.findElementByAndroidUIAutomator(locator).click();
    }
    public void clickElement(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void sendKeysElement(AndroidElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }
    public void androidKeyEvent(AndroidKey KEY) {
        driver.pressKey(new KeyEvent(KEY));
    }
}
