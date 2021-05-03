package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputTitle {
    WebDriver driver;
    String locator = "//*[text()='%s']/parent::div//input";
    String label;

    public InputTitle(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
    }
}
