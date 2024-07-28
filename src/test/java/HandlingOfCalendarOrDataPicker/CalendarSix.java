package HandlingOfCalendarOrDataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSix {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        driver.findElement(By.id("third_date_picker")).click();
        WebElement month = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(month);
        select.selectByVisibleText("Nov");
        WebElement year = driver.findElement(By.className("ui-datepicker-year"));
        Select select1 = new Select(year);
        select1.selectByVisibleText("2026");
        driver.findElement(By.xpath("//*[@data-handler='selectDay']//*[text()='23']")).click();

    }
}
