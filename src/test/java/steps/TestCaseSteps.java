package steps;

import io.qameta.allure.Step;
import models.Suite;
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

    @Step("Create a test case")
    public TestCaseSteps createTestCase(TestCase testCase, Suite suite) {
        testRepositoryPage
                .openTestCasePage()
                .fillTestCaseForm(testCase, suite);
        return this;
    }

    @Step("Check the creation of a test case")
    public TestCaseSteps verifyCreatedCase(TestCase testCase) {
        assertTrue(testRepositoryPage.verifyCreatedTestCase(testCase));
        return this;
    }

    @Step("Delete created test case")
    public TestCaseSteps deleteTestCase(TestCase testCase) {
        testRepositoryPage.deleteTestCase();
        return this;
    }
}
