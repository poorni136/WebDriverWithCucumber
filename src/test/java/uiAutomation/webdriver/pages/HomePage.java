package uiAutomation.webdriver.pages;

import uiAutomation.webdriver.TestContext;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By signInLink = By.cssSelector("[data-test='nav-sign-in']");

    public HomePage(TestContext context) {
        super(context.getDriver());
    }

    public void navigateToSignIn() {
        driver.findElement(signInLink).click();
    }
}
