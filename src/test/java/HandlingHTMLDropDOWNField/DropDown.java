package HandlingHTMLDropDOWNField;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        WebElement dropdownField=driver.findElement(By.id("drop1"));
        Select select = new Select(dropdownField);
        select.selectByVisibleText("doc 3");
        select.selectByIndex(4);

        List<WebElement> options = select.getOptions();
        for (WebElement option :options){
            System.out.println(option.getText());
        }
        driver.quit();
    }
}
