package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuiteModalPage extends BasePage {
    private static final By SUITE_NAME_INPUT = By.id("name");
    private static final By PARENT_SUITE_DROPDOWN = By.xpath("//label[contains(text(),'Parent suite')]/ancestor::div[contains(@id,'parent_idGroup')]//div[1]");
    private static final By DESCRIPTION_INPUT = By.xpath("//*[contains(text(),'Description')]/ancestor::div[contains(@class,'form-group')]//p");
    private static final By PRECONDITIONS_INPUT = By.xpath("//*[contains(text(),'Preconditions')]/ancestor::div[contains(@class,'form-group')]//p");
    private static final By CREATE_SUITE_BUTTON = By.id("save-suite-button");

    public SuiteModalPage(WebDriver driver) {
        super(driver);
    }

    public TestRepositoryPage fillSuiteForm() {
        driver.findElement(SUITE_NAME_INPUT).sendKeys("");
        driver.findElement(PARENT_SUITE_DROPDOWN).sendKeys("");
        driver.findElement(DESCRIPTION_INPUT).sendKeys(""); //возможно нужно сначала кликнуть
        driver.findElement(PRECONDITIONS_INPUT).sendKeys(""); //возможно нужно сначала кликнуть
        driver.findElement(CREATE_SUITE_BUTTON).click();
        return new TestRepositoryPage(driver);
    }

}
