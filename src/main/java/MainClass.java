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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuzmin_ad\\QA_Auto\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://dineshvelhal.github.io/testautomation-playground/expected_conditions.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (!driver.findElement(By.xpath("//button[@id='enabled_target']")).isEnabled()) {
            driver.findElement(By.xpath("//button[@id='enabled_trigger']")).click();
            driver.findElement(By.xpath("//button[@id='enabled_target']")).click();
        }

        if (driver.findElement(By.xpath("//div[@id='invisibility_target']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@id='invisibility_trigger']")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='invisibility_trigger']")));

            if (!driver.findElement(By.xpath("//div[@id='invisibility_target']")).isDisplayed())
            {
                System.out.println("Element is gone! Success!");
            }
            else System.out.println("Element is here! Fail!");
        }


    }
}
