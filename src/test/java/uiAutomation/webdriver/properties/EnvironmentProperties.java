package uiAutomation.webdriver.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:src/test/resources/environments/${env}_environment.properties" )
public interface EnvironmentProperties extends Config {
	String browser();
	
    String url();

    String email();

    String password();
}
