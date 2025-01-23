package uiAutomation.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import io.testsmith.support.listeners.HighlightElementsListener;
import io.testsmith.support.listeners.SavePageSourceOnExceptionListener;
import io.testsmith.support.listeners.SaveScreenshotOnExceptionListener;
import io.testsmith.support.listeners.WebDriverLoggingListener;

public class TestContext {

	    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    public WebDriver getDriver() {
	        return driver.get();
	    }

	    public void setDriver(WebDriver driver) {
	        this.driver.set(driver);
	    }
	
	    public void initializeDriver(WebDriver originalDriver) {
	        this.setDriver(new EventFiringDecorator<WebDriver>(
	                new WebDriverLoggingListener(),
	                new SavePageSourceOnExceptionListener(originalDriver, "target/log/pagesources"),
	                new SaveScreenshotOnExceptionListener(originalDriver, "target/log/screenshots"),
	                new HighlightElementsListener()
	        ).decorate(originalDriver));
	        
	      
	    }
}
