package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String locator = "//*[text()='%s']/parent::div//div[contains(@class, 'container')]";
    String option = "//*[contains(@id, 'react-select') and contains(text(),'%s')]";
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        driver.findElement(By.xpath(String.format(option, text))).click();
    }
}
