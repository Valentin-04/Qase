package tests;

import models.Project;
import org.testng.annotations.Test;
import utils.Retry;

public class CreateProjectTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create a project")
    public void createProject() {
        loginSteps.login(EMAIL, PASSWORD);
        project = Project.builder()
                .projectName(faker.funnyName().name())
                .projectCode(faker.hacker().abbreviation())
                .description(faker.hobbit().location())
                .build();
        projectSteps
                .createNewProject(project)
                .verifyProject(project);
    }
}
