package uiAutomation.webdriver;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import uiAutomation.webdriver.properties.Environment;
import uiAutomation.webdriver.utils.BrowserUtil;
//import uiAutomation.webdriver.properties.ConfigManager;

public class Hooks {
	 private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());
	 private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }
    
    @Before
    public void setup() {
        // Fetch browser type and other configurations from a central ConfigManager
    	 LOGGER.info("Initializing WebDriver for the scenario...");
    	
    	
    	 try {
             String browser = Environment.getProperties().browser();
             WebDriver originalDriver = BrowserUtil.createDriver(browser);
             testContext.initializeDriver(originalDriver);
             testContext.getDriver().manage().window().maximize();
             testContext.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
             testContext.getDriver().get(Environment.getProperties().url());
             LOGGER.info("WebDriver initialized and navigated to URL: " + Environment.getProperties().url());
         } catch (Exception e) {
             LOGGER.severe("Failed to initialize the WebDriver: " + e.getMessage());
             throw new RuntimeException(e);
         }
    }

	
	

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) this.testContext.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @After(order = 0)
    public void tearDown() {
        // Quit the decorated WebDriver instance
        if (testContext.getDriver() != null) {
            testContext.getDriver().quit();
        }
    }
}
