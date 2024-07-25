package HandlngGenericFunctionsForDropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateGenericFunctions {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/dropdowns");
        By fruits = By.id("fruits");
        By language = By.id("lang");

//        Select select1 = new Select(driver.findElement(fruits));
//        select1.selectByVisibleText("Orange");
//        Select select2 = new Select(driver.findElement(language));
//        select2.selectByVisibleText("Java");
        //create genaric Methode
        selectOptionsInDropDownFiledByVisabilityText(fruits,"Orange");
        selectOptionsInDropDownFiledByVisabilityText(language,"Java");
        selectOptionsInDropDownFiledByIndex(fruits,"1");

    }
    public static WebElement getWebElement(By field){
        return driver.findElement(field);
    }
    public static void selectOptionsInDropDownFiledByVisabilityText(By field,String options){
        Select select  = new Select(getWebElement(field));
        select.selectByVisibleText(options);

    }
    public static void selectOptionsInDropDownFiledByIndex(By field,String index){
        Select select  = new Select(getWebElement(field));
        select.selectByIndex(Integer.parseInt(index));

    }
}
