package tests;

import models.Project;
import org.testng.annotations.Test;
import utils.Retry;

public class DeleteProjectTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Delete the first project in the list")
    public void deleteProject() {
        loginSteps.login(EMAIL, PASSWORD);
        project = Project.builder()
                .projectName(faker.funnyName().name())
                .projectCode(faker.hacker().abbreviation())
                .description(faker.hobbit().location())
                .build();
        projectSteps
                .createNewProject(project)
                .deleteCreatedProject();
    }
}
