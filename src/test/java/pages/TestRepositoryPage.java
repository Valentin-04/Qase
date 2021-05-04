package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class TestRepositoryPage extends BasePage {
    private static final By PAGE_NAME = By.xpath("//div[contains(@class,'app')]//h1");//TODO кривой надо переделать
    private static final By CREATE_SUITE_BUTTON = By.id("create-suite-button");
    private static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    private static final By PROJECT_MENU_BUTTON = By.xpath("//span[contains(@class,'nav') and contains(text(),'Project')]");
    private static final By SUITE_TITLE = By.className("suite-header-title");
    private static final By DELETE_SUITE_BUTTON = By.xpath("//a[text()='%s']/parent::span//i[contains(@class,'fa-trash')]");


    public TestRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public SuiteModalPage openSuiteModalWindow() {
        driver.findElement(CREATE_SUITE_BUTTON).click();
        return new SuiteModalPage(driver);
    }

    public TestCasePage openTestCasePage() {
        driver.findElement(CREATE_CASE_BUTTON).click();
        return new TestCasePage(driver);
    }

    public ProjectsPage backToProjectPage() {
        driver.findElement(PROJECT_MENU_BUTTON).click();
        return new ProjectsPage(driver);
    }

    public TestRepositoryPage verifyTestRepositoryOpened() {
        try {
            String page = driver.findElement(PAGE_NAME).getText();
            assertEquals(page, "Test Repository");
        } catch (NullPointerException ex) {
            Assert.fail("Test Repository page didn't load");
        }
        return this;
    }
}
