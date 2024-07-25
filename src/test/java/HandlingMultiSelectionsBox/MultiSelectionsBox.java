package HandlingMultiSelectionsBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectionsBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        WebElement multiSelectionDropDown = driver.findElement(By.id("multiselect1"));
        Select select = new Select(multiSelectionDropDown);
        select.selectByVisibleText("Volvo");
        select.selectByIndex(3);
        select.deselectByIndex(3);

        System.out.println(select.isMultiple());

        List<WebElement> options = select.getAllSelectedOptions();
        for (WebElement option:options){
            System.out.println(option.getText());
        }
    }
}
