package HandlingOfCalendarOrDataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarTwoWithJavaScriptExecutor {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("document.getElementById('datepicker').value='01/26/2025'"); // находи локатор --> идем в консоль и пишем document.getElementById('Локатор'),  и дописываем дату

    }
}
