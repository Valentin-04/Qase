package tests;

import models.Project;
import models.Suite;
import org.testng.annotations.Test;
import utils.Retry;

public class CreateFirstSuiteTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create the first suite in the project")
    public void createFirstSuite() {
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
    }
}
