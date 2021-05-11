package pages;

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
    private static final By ADD_STEP_BUTTON = By.id("add-step");
    private static final By SAVE_CASE_BUTTON = By.id("save-case");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    public TestRepositoryPage fillTestCaseForm(TestCase testCase) {
        new InputTitle(driver, "Title").write(testCase.getTitle());
        new DropDown(driver, "Status").select(testCase.getStatus());
        new Input(driver, "Description").write(testCase.getDescription());
        new DropDown(driver, "Suite").select(testCase.getSuite());
        new DropDown(driver, "Severity").select(testCase.getSeverity());
        new DropDown(driver, "Priority").select(testCase.getPriority());
        new DropDown(driver, "Type").select(testCase.getType());
        new DropDown(driver, "Layer").select(testCase.getLayer());
        new DropDown(driver, "Is Flaky").select(testCase.getIsFlaky());
        new DropDown(driver, "Behavior").select(testCase.getBehavior());
        new DropDown(driver, "Automation status").select(testCase.getAutomationStatus());
        new Input(driver, "Pre-conditions").write(testCase.getPreConditions());
        new Input(driver, "Post-conditions").write(testCase.getPostConditions());
//        addStep();
//        new Input(driver,"Action").write(testCase.getAction());
//        new Input(driver, "Input data").write(testCase.getInputData());
//        new Input(driver,"Expected result").write(testCase.getExpectedResult());
        driver.findElement(SAVE_CASE_BUTTON).click();
        return new TestRepositoryPage(driver);
    }

    private void addStep() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_STEP_BUTTON));
            driver.findElement(ADD_STEP_BUTTON).click();
        } catch (TimeoutException ex) {
            Assert.fail("Button is not found");
        }
    }

    private void isTestCasePageOpened() {
        //TODO добавить метод дожидающийся загрузки элементов
    }
}
