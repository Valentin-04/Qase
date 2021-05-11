package steps;

import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.TestRepositoryPage;

import static org.testng.Assert.assertTrue;

public class TestCaseSteps {
    WebDriver driver;
    TestRepositoryPage testRepositoryPage;

    public TestCaseSteps(WebDriver driver) {
        this.driver = driver;
        testRepositoryPage = new TestRepositoryPage(driver);
    }

    public TestCaseSteps createTestCase(TestCase testCase) {
        testRepositoryPage
                .openTestCasePage()
                .fillTestCaseForm(testCase);
        assertTrue(testRepositoryPage.verifyCreatedTestCase(testCase));
        return this;
    }

    public TestCaseSteps deleteTestCase(TestCase testCase) {
        testRepositoryPage.deleteTestCase();
        return this;
    }
}
