package tests;

import models.Project;
import models.Suite;
import org.testng.annotations.Test;
import utils.Retry;

public class DeleteSuiteTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Remove suite from project")
    public void deleteCreatedSuite() {
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
        suiteSteps
                .createFirstSuiteInProject(suite, project)
                .deleteSuite();
    }
}
