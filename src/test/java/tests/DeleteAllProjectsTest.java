package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class DeleteAllProjectsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Delete all projects")
    public void deleteAllProjects() {
        loginSteps.login(EMAIL, PASSWORD);
        projectSteps.deleteAllCreatedProject();
    }
}
