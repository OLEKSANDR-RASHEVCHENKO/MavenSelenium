package HandlingJQueryDropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQuery {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        WebElement singleSelectionDropDownField = driver.findElement(By.id("justAnotherInputBox"));
        singleSelectionDropDownField.click();
        WebElement choice3Options = driver.findElement(By.xpath("(//span[text()='choice 3'])[3]"));
        choice3Options.click();

    }
}
