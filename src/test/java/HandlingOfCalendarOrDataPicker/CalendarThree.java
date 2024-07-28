package HandlingOfCalendarOrDataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarThree {
    static WebDriver driver = null;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.path2usa.com/travel-companions");
        WebElement calendarElement = driver.findElement(By.id("form-field-travel_comp_date"));
        calendarElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("flatpickr-calendar animate arrowTop open")));
        selectDateInCalendar("1", "October", "2040");


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
        String monthYear = driver.findElement(By.className("flatpickr-current-month")).getText();

        String month = monthYear.split(" ")[0];
        String year = monthYear.split(" ")[1];
        while (!(month.equals(selectMonth) && year.equals(selectYear))) {
            driver.findElement(By.xpath("//*[@title = 'Next']")).click();

            monthYear = driver.findElement(By.className("flatpickr-current-month")).getText();
            month = monthYear.split(" ")[0];
            year = monthYear.split(" ")[1];
        }
        try {
            driver.findElement(By.xpath("//*[@data-handler='selectDay']//*[text()='" + selectDay + "']")).click();
        } catch (Exception e) {
            System.out.println("Invalid data");
        }

        ///LOOK IN THE  SESSION  8 /121 SELENIUM Javaa : beginner to advanced 50 min ---->

    }
}
