import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.9.1");
    }
}
