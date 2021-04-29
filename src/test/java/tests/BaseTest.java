package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.ProjectSteps;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = System.getenv("email");
    public static final String PASSWORD = System.getenv("password");
    public LoginSteps loginSteps;
    public ProjectSteps projectSteps;
    public WebDriver driver;
    public Faker faker;
    Project project;

    @BeforeMethod
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//CapabilitiesGenerator.getChromeOptions()
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginSteps = new LoginSteps(driver);
        projectSteps = new ProjectSteps(driver);
        faker = new Faker();
        project = new Project();
        context.setAttribute("browser", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
