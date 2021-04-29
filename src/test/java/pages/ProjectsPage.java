package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private static final By NAME_OF_PROJECT = By.className("defect-title");
    private static final String DROPDOWN_MENU_OF_PROJECT = "//*[contains(text(),'%s')]/ancestor::tr//a[contains(@class,'btn-dropdown')]";
    private static final String PROJECT_DELETE_BUTTON = "//*[contains(text(),'%s')]/ancestor::tr//a[contains(@class,'btn-dropdown')]/following::a[contains(@class,'text-danger')]";
    private static final By CONFIRM_DELETE_BUTTON = By.className("btn-cancel");
    private static final By INPUT_PROJECT_NAME = By.name("title");
    private static final By INPUT_PROJECT_CODE = By.name("code");
    private static final By TEXTAREA_DESCRIPTION = By.name("description");
    private static final By CREATE_PROJECT_BUTTON = By.xpath("//*[text()='Create project']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage openProjectsPage() {
        driver.get(URL + "/projects");
        isProjectPageOpened(CREATE_NEW_PROJECT_BUTTON);
        return this;
    }

    public ProjectsPage createProject(Project project) {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
        isProjectPageOpened(CREATE_PROJECT_BUTTON);
        driver.findElement(INPUT_PROJECT_NAME).sendKeys(project.getProjectName());
        driver.findElement(INPUT_PROJECT_CODE).sendKeys(project.getProjectCode());
        driver.findElement(TEXTAREA_DESCRIPTION).sendKeys(project.getDescription());
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        return this;
    }

    public ProjectsPage deleteProject() {
        driver.findElement(By.xpath(String.format(DROPDOWN_MENU_OF_PROJECT, getProjectName()))).click();
        driver.findElement(By.xpath(String.format(PROJECT_DELETE_BUTTON, getProjectName()))).click();
        isProjectPageOpened(CONFIRM_DELETE_BUTTON);
        driver.findElement(CONFIRM_DELETE_BUTTON).click();
        isProjectPageOpened(CREATE_NEW_PROJECT_BUTTON);
        return this;
    }

    public String getProjectName() {
        String nameOfProject;
        List<WebElement> listOfProjectsNames = driver.findElements(NAME_OF_PROJECT);
        nameOfProject = listOfProjectsNames.get(0).getText();
        return nameOfProject;
    }

    public ProjectsPage isProjectPageOpened(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException ex) {
            Assert.fail("Projects page didn't load");
        }
        return this;
    }

    public boolean verifyLogin() {
        boolean open = false;
        open = driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
        return open;
    }
}
