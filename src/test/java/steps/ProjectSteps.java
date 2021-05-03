package steps;

import models.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

import static org.testng.Assert.assertTrue;

public class ProjectSteps {
    ProjectsPage projectsPage;
    WebDriver driver;

    public ProjectSteps(WebDriver driver) {
        this.driver = driver;
        projectsPage = new ProjectsPage(driver);
    }

    public ProjectSteps createNewProject(Project project) {
        projectsPage
                .openProjectsPage()
                .createProject(project)
                .backToProjectPage();
        assertTrue(projectsPage.verifyCreatedProject(project));
        return this;
    }

    public ProjectSteps deleteCreatedProject() {
        projectsPage
                .openProjectsPage()
                .deleteProject();
        return this;
    }
}
