package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProjectsPage projectsPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    public LoginSteps login(String email, String password) {
        loginPage
                .open()
                .login(email, password);
        assertTrue(projectsPage.verifyLogin());
        return this;
    }
}
