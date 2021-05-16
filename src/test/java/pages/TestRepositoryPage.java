package pages;

import io.qameta.allure.Step;
import models.Project;
import models.Suite;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestRepositoryPage extends BasePage {
    private static final By CREATE_FIRST_SUITE = By.xpath("//*[contains(text(),'Create new suite')]");
    private static final By PROJECT_PAGE_NAME = By.xpath("//p[contains(@class,'header')]");
    private static final By CREATE_SUITE_BUTTON = By.id("create-suite-button");
    private static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    private static final By PROJECT_MENU_BUTTON = By.xpath("//span[contains(@class,'nav') and contains(text(),'Project')]");
    private static final By SUITE_TITLE = By.className("suite-header-title");
    private static final String DELETE_SUITE_BUTTON = "//a[text()='%s']/parent::span//i[contains(@class,'fa-trash')]";
    private static final By CONFIRM_DELETE_SUITE_BUTTON = By.className("btn-danger");
    private static final By TEST_CASE_NAME = By.className("case-row-title");
    private static final String CASE_NAME_FOR_CLICK = "//*[contains(@class,'case-row-title') and text()='%s']";
    private static final By DELETE_CASE_BUTTON = By.xpath("//button[contains(text(),'Delete')]");

    public TestRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open a modal window to create a suite")
    public SuiteModalPage openFirstSuiteModalWindow() {
        driver.findElement(CREATE_FIRST_SUITE).click();
        return new SuiteModalPage(driver);
    }

    @Step("Open a modal window to create a suite")
    public SuiteModalPage openSuiteModalWindow() {
        driver.findElement(CREATE_SUITE_BUTTON).click();
        return new SuiteModalPage(driver);
    }

    @Step("Deleting a suite")
    public TestRepositoryPage deleteSuite() {
        List<WebElement> listOfSuites = driver.findElements(SUITE_TITLE);
        driver.findElement(By.xpath(String.format(DELETE_SUITE_BUTTON, listOfSuites.get(0).getText()))).click();
        driver.findElement(CONFIRM_DELETE_SUITE_BUTTON).click();
        return this;
    }

    @Step("Checking the created suite")
    public boolean verifyCreatedSuite(Suite suite) {
        boolean created = false;
        List<WebElement> listOfSuites = driver.findElements(SUITE_TITLE);
        try {
            for (int i = 0; i < listOfSuites.size(); i++) {
                if (suite.getSuiteName().equals(listOfSuites.get(i).getText())) {
                    created = true;
                }
            }
        } catch (NullPointerException ex) {
            Assert.fail("Suite not found");
        }
        return created;
    }

    @Step("Open the test case creation page")
    public TestCasePage openTestCasePage() {
        driver.findElement(CREATE_CASE_BUTTON).click();
        return new TestCasePage(driver);
    }

    @Step("Deleting the first test case in the list")
    public TestRepositoryPage deleteTestCase() {
        List<WebElement> listOfCasesNames = driver.findElements(TEST_CASE_NAME);
        driver.findElement(By.xpath(String.format(CASE_NAME_FOR_CLICK, listOfCasesNames.get(0).getText()))).click();
        driver.findElement(DELETE_CASE_BUTTON).click();
        driver.findElement(CONFIRM_DELETE_SUITE_BUTTON).click();
        return this;
    }

    public boolean verifyCreatedTestCase(TestCase testCase) {
        boolean created = false;
        List<WebElement> listOfCasesNames = driver.findElements(TEST_CASE_NAME);
        try {
            for (int i = 0; i < listOfCasesNames.size(); i++) {
                if (testCase.getTitle().equals(listOfCasesNames.get(i).getText())) {
                    created = true;
                }
            }
        } catch (NullPointerException ex) {
            Assert.fail("Test Case not found");
        }
        return created;
    }

    @Step("Return to the projects page from the test repository page")
    public ProjectsPage backToProjectPage() {
        driver.findElement(PROJECT_MENU_BUTTON).click();
        return new ProjectsPage(driver);
    }

    public TestRepositoryPage verifyTestRepositoryOpened(Project project) {
        try {
            String page = driver.findElement(PROJECT_PAGE_NAME).getText();
            assertEquals(page, project.getProjectName());
        } catch (NullPointerException ex) {
            Assert.fail("Test Repository page didn't load");
        }
        return this;
    }
}
