package steps;

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

    public SuiteSteps createNewSuite(Suite suite, Project project) {
        testRepositoryPage
                .verifyTestRepositoryOpened(project)
                .openSuiteModalWindow();
        suiteModalPage
                .isSuiteModalOpened()
                .fillSuiteForm(suite)
                .clickCreateSuiteButton();
        testRepositoryPage.verifyCreatedSuite(suite);
        return this;
    }

    public SuiteSteps deleteSuite() {
        testRepositoryPage.deleteSuite();
        return this;
    }
}
