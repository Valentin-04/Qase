package steps;

import models.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

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
                .createProject(project);
        return this;
    }
}
