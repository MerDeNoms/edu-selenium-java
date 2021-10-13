import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://QA_Auto/chromedriver_win32/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://dineshvelhal.github.io/testautomation-playground/expected_conditions.html");
        driver.findElement(By.xpath("//button[text()='Show Alert']")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        if (driver.findElement(By.xpath("//span[@id='alert_handled_badge']")).getText().equals("Alert handled")) {
            System.out.println("Alert handled");
        }
        else System.out.println("Alert isn't handled");

        driver.get("https://www.google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("confirm('Are you sure?');");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();

    }
}
