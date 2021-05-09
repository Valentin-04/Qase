package tests;

import org.testng.annotations.Test;

public class DeleteAllProjectsTest extends BaseTest {

    @Test
    public void deleteAllProjects() {
        loginSteps.login(EMAIL, PASSWORD);
        projectSteps.deleteAllCreatedProject();
    }
}
