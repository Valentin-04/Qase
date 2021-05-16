package steps;

import io.qameta.allure.Step;
import models.Project;
import models.Suite;
import org.openqa.selenium.WebDriver;
import pages.SuiteModalPage;
import pages.TestRepositoryPage;

public class SuiteSteps {
    WebDriver driver;
    SuiteModalPage suiteModalPage;
    TestRepositoryPage testRepositoryPage;


    public SuiteSteps(WebDriver driver) {
        this.driver = driver;
        suiteModalPage = new SuiteModalPage(driver);
        testRepositoryPage = new TestRepositoryPage(driver);
    }

    @Step("Create a new test suite")
    public SuiteSteps createFirstSuiteInProject(Suite suite, Project project) {
        testRepositoryPage
                .verifyTestRepositoryOpened(project)
                .openFirstSuiteModalWindow();
        suiteModalPage
                .isSuiteModalOpened()
                .fillFirstSuiteForm(suite)
                .clickCreateSuiteButton();
        testRepositoryPage.verifyCreatedSuite(suite);
        return this;
    }

    @Step("Delete created test suite")
    public SuiteSteps deleteSuite() {
        testRepositoryPage.deleteSuite();
        return this;
    }
}
