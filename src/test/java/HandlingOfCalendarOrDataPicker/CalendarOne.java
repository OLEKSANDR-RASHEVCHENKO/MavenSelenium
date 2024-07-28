package HandlingOfCalendarOrDataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarOne {
    static WebDriver driver = null;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement calendarElement = driver.findElement(By.id("datepicker"));
        calendarElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
        selectDateInCalendar("1", "October", "2080");


    }

    public static void selectDateInCalendar(String selectDay, String selectMonth, String selectYear) {
        if (Integer.parseInt(selectDay) > 31) {
            System.out.println("Invalid date provided" + selectDay + " /" + selectMonth + " /" + selectYear + " /");
            return;
        }
        if (selectMonth.equals("February") && Integer.parseInt(selectDay) > 29) {
            System.out.println("Invalid date provided" + selectDay + " /" + selectMonth + " /" + selectYear + " /");
            return;
        }
        String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();

        String month = monthYear.split(" ")[0];
        String year = monthYear.split(" ")[1];
        while (!(month.equals(selectMonth) && year.equals(selectYear))) {
            driver.findElement(By.xpath("//*[@title = 'Next']")).click();

            monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
            month = monthYear.split(" ")[0];
            year = monthYear.split(" ")[1];
        }
        try {
            driver.findElement(By.xpath("//*[@data-handler='selectDay']//*[text()='" + selectDay + "']")).click();
        } catch (Exception e) {
            System.out.println("Invalid data");
        }
    }
}