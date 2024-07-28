package HandlingOfCalendarOrDataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class CalendarFour {
    static WebDriver driver = null;
    public static void main(String[] args) {
        String eDate = "27-07-2025";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate eld = LocalDate.parse(eDate, dtf);
        int eDay=eld.getDayOfMonth();
        int eMonth = eld.getMonthValue();
        int eYear = eld.getYear();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement calendarElement = driver.findElement(By.id("datepicker"));
        calendarElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

        String aMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
        int month = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(aMonth).get(ChronoField.MONTH_OF_YEAR);
        String aYear=driver.findElement(By.className("ui-datepicker-year")).getText();
        int year=Integer.parseInt(aYear);

        while (eMonth<month || eYear<year){
            driver.findElement(By.xpath("//*[text()='Prev']")).click();
            aMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
            month = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(aMonth).get(ChronoField.MONTH_OF_YEAR);
            aYear=driver.findElement(By.className("ui-datepicker-year")).getText();
            year=Integer.parseInt(aYear);
        }
        while (eMonth>month || eYear>year){
            driver.findElement(By.xpath("//*[text()='Next']")).click();
            aMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
            month = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(aMonth).get(ChronoField.MONTH_OF_YEAR);
            aYear=driver.findElement(By.className("ui-datepicker-year")).getText();
            year=Integer.parseInt(aYear);
        }
        String xpathText = "//*[@data-handler='selectDay']//*[text()='"+eDay+"']";
        driver.findElement(By.xpath(xpathText)).click();
    }
}
