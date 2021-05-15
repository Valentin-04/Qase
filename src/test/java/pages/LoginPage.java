package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private static final By LOGIN_INPUT = By.id("inputEmail");
    private static final By PASSWORD_INPUT = By.id("inputPassword");
    private static final By LOGIN_BUTTON = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public LoginPage open() {
        driver.get(URL + "/login");
        isLoginPageOpened();
        return this;
    }

    @Step("Fill in the authorization form")
    public ProjectsPage login(String login, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProjectsPage(driver);
    }

    public LoginPage isLoginPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Login page didn't load");
        }
        return this;
    }
}
