package tests;

import models.Project;
import models.Suite;
import models.TestCase;
import org.testng.annotations.Test;

public class DeleteTestCaseTest extends BaseTest {

    @Test
    public void deleteTestCase() {
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
                .layer("E2E")
                .isFlaky("No")
                .behavior("Positive")
                .automationStatus("Automated")
                .preConditions(faker.beer().name())
                .postConditions(faker.book().title())
                .action(faker.chuckNorris().fact())
                .inputData(faker.business().creditCardNumber())
                .expectedResult(faker.food().dish())
                .build();
        testCaseSteps
                .createTestCase(testCase)
                .deleteTestCase(testCase);
    }
}
