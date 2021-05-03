package tests;

import org.testng.annotations.Test;

public class DeleteProjectTest extends BaseTest {

    @Test
    public void deleteProject() {
        loginSteps.login(EMAIL, PASSWORD);
        projectSteps.deleteCreatedProject();
    }
}
