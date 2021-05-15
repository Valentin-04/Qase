package pages;

import io.qameta.allure.Step;
import models.Suite;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.InputTitle;

public class TestCasePage extends BasePage {
    private static final By SAVE_CASE_BUTTON = By.id("save-case");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill out the test case creation form")
    public TestRepositoryPage fillTestCaseForm(TestCase testCase, Suite suite) {
        isTestCasePageOpened();
        new InputTitle(driver, "Title").write(testCase.getTitle());
        new DropDown(driver, "Status").select(testCase.getStatus());
        new Input(driver, "Description").write(testCase.getDescription());
        new DropDown(driver, "Suite").select(suite.getSuiteName());
        new DropDown(driver, "Severity").select(testCase.getSeverity());
        new DropDown(driver, "Priority").select(testCase.getPriority());
        new DropDown(driver, "Type").select(testCase.getType());
        new DropDown(driver, "Behavior").select(testCase.getBehavior());
        new DropDown(driver, "Automation status").select(testCase.getAutomationStatus());
        new Input(driver, "Pre-conditions").write(testCase.getPreConditions());
        new Input(driver, "Post-conditions").write(testCase.getPostConditions());
        driver.findElement(SAVE_CASE_BUTTON).click();
        return new TestRepositoryPage(driver);
    }

    private TestCasePage isTestCasePageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_CASE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Test case page didn't load");
        }
        return this;
    }
}
