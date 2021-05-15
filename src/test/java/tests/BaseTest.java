package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.Project;
import models.Suite;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.SuiteSteps;
import steps.TestCaseSteps;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = System.getenv("email");
    public static final String PASSWORD = System.getenv("password");
    public LoginSteps loginSteps;
    public ProjectSteps projectSteps;
    public SuiteSteps suiteSteps;
    public TestCaseSteps testCaseSteps;
    public WebDriver driver;
    public Faker faker;
    Project project;
    Suite suite;
    TestCase testCase;

    @BeforeMethod(description = "Opening browser")
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginSteps = new LoginSteps(driver);
        projectSteps = new ProjectSteps(driver);
        suiteSteps = new SuiteSteps(driver);
        testCaseSteps = new TestCaseSteps(driver);
        faker = new Faker();
        project = new Project();
        suite = new Suite();
        testCase = new TestCase();
        context.setAttribute("browser", driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closer browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
