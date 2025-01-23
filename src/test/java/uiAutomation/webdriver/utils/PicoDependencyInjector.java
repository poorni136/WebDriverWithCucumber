package uiAutomation.webdriver.utils;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;
import uiAutomation.webdriver.pages.AccountPage;
import uiAutomation.webdriver.pages.HomePage;
import uiAutomation.webdriver.pages.LoginPage;

public class PicoDependencyInjector implements ObjectFactory {

    private PicoFactory delegate = new PicoFactory();

    public PicoDependencyInjector() {
        addClass(HomePage.class);
        addClass(LoginPage.class);
        addClass(AccountPage.class);
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
}