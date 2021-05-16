package tests;

import models.Project;
import models.Suite;
import models.TestCase;
import org.testng.annotations.Test;
import utils.Retry;

public class CreateTestCaseTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create a test case")
    public void createTestCase() {
        loginSteps.login(EMAIL, PASSWORD);
        project = Project.builder()
                .projectName(faker.funnyName().name())
                .projectCode(faker.hacker().abbreviation())
                .description(faker.hobbit().location())
                .build();
        projectSteps.createNewProject(project);
        suite = Suite.builder()
                .suiteName(faker.funnyName().name())
                .description(faker.hobbit().location())
                .preconditions(faker.hobbit().location())
                .build();
        suiteSteps.createFirstSuiteInProject(suite, project);
        testCase = TestCase.builder()
                .title(faker.funnyName().name())
                .status("Actual")
                .description(faker.hobbit().quote())
                .suite(suite.getSuiteName())
                .severity("Major")
                .priority("High")
                .type("Smoke")
                .behavior("Positive")
                .automationStatus("Automated")
                .preConditions(faker.beer().name())
                .postConditions(faker.book().title())
                .build();
        testCaseSteps
                .createTestCase(testCase, suite)
                .verifyCreatedCase(testCase);
    }
}
