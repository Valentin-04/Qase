package tests;

import models.Project;
import org.testng.annotations.Test;

public class CreateSuiteTest extends BaseTest {

    @Test
    public void createSuite() {
        loginSteps.login(EMAIL, PASSWORD);
        project = Project.builder()
                .projectName(faker.funnyName().name())
                .projectCode(faker.hacker().abbreviation())
                .description(faker.hobbit().location())
                .build();
        projectSteps.createNewProject(project);

    }
}
