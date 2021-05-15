package pages;

import io.qameta.allure.Step;
import models.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SuiteModalPage extends BasePage {
    private static final By SUITE_NAME_INPUT = By.id("name");
    private static final By DESCRIPTION_INPUT = By.xpath("//*[contains(text(),'Description')]/ancestor::div[contains(@class,'form-group')]//p");
    private static final By PRECONDITIONS_INPUT = By.xpath("//*[contains(text(),'Preconditions')]/ancestor::div[contains(@class,'form-group')]//p");
    private static final By CREATE_SUITE_BUTTON = By.id("save-suite-button");

    public SuiteModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill out the form for creating a test suite")
    public SuiteModalPage fillFirstSuiteForm(Suite suite) {
        isSuiteModalOpened();
        driver.findElement(SUITE_NAME_INPUT).sendKeys(suite.getSuiteName());
        driver.findElement(DESCRIPTION_INPUT).click();
        driver.findElement(DESCRIPTION_INPUT).sendKeys(suite.getDescription());
        driver.findElement(PRECONDITIONS_INPUT).click();
        driver.findElement(PRECONDITIONS_INPUT).sendKeys(suite.getPreconditions());
        return this;
    }

    @Step("Click on the button to create a test suite")
    public TestRepositoryPage clickCreateSuiteButton() {
        driver.findElement(CREATE_SUITE_BUTTON).click();
        return new TestRepositoryPage(driver);
    }

    @Step("Checking the open modal window of the test suite")
    public SuiteModalPage isSuiteModalOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_SUITE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Suite modal window didn't load");
        }
        return this;
    }

}
