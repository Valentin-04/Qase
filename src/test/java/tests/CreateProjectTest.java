package tests;

import models.Project;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseTest {

    @Test
    public void createProject() {
        loginSteps.login(EMAIL, PASSWORD);
        project = Project.builder()
                .projectName(faker.funnyName().name())
                .projectCode(faker.hacker().abbreviation())
                .description(faker.hobbit().location())
                .build();
        projectSteps.createNewProject(project);
    }
}
