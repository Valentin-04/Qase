package steps;

import models.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;
import pages.TestRepositoryPage;

import static org.testng.Assert.assertTrue;

public class ProjectSteps {
    ProjectsPage projectsPage;
    TestRepositoryPage testRepositoryPage;
    WebDriver driver;

    public ProjectSteps(WebDriver driver) {
        this.driver = driver;
        projectsPage = new ProjectsPage(driver);
        testRepositoryPage = new TestRepositoryPage(driver);
    }

    public ProjectSteps createNewProject(Project project) {
        projectsPage
                .openProjectsPage()
                .createProject(project);
        return this;
    }

    public ProjectSteps verifyProject(Project project) {
        testRepositoryPage.backToProjectPage();
        assertTrue(projectsPage.verifyCreatedProject(project));
        return this;
    }

    public ProjectSteps deleteCreatedProject() {
        projectsPage
                .openProjectsPage()
                .deleteProject();
        return this;
    }

    public ProjectSteps deleteAllCreatedProject() {
        projectsPage
                .openProjectsPage()
                .deleteAllProjects();
        return this;
    }
}
