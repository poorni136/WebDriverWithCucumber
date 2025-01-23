package uiAutomation.webdriver.pages;

import uiAutomation.webdriver.TestContext;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    private final By pageTitle = By.cssSelector("h1[data-test='page-title']");

    public AccountPage(TestContext context) {
        super(context.getDriver());
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}
