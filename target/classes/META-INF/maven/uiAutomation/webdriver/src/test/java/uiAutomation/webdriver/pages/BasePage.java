package uiAutomation.webdriver.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;

    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L)); // Default wait time
    }
    /**
     * Waits for an element to be visible on the page.
     * 
     * @param locator The By locator of the element
     * @return The visible WebElement
     */
    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable on the page.
     * 
     * @param locator The By locator of the element
     * @return The clickable WebElement
     */
    protected WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Clicks on an element after waiting for it to be clickable.
     * 
     * @param locator The By locator of the element
     */
    protected void click(By locator) {
        waitForClickability(locator).click();
    }

    /**
     * Sends keys to an input field after waiting for it to be visible.
     * 
     * @param locator The By locator of the element
     * @param text    The text to send
     */
    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets the text of a visible element.
     * 
     * @param locator The By locator of the element
     * @return The text of the element
     */
    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    /**
     * Checks if an element is displayed.
     * 
     * @param locator The By locator of the element
     * @return True if the element is displayed, otherwise false
     */
    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Navigates to a specified URL.
     * 
     * @param url The URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

}
