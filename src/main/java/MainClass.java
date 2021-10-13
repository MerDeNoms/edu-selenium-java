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

        driver.get("https://dineshvelhal.github.io/testautomation-playground/multi_window.html");
        String mainTab = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Open New Window 1']")).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        driver.findElement(By.xpath("//button")).click();

        if (driver.findElement(By.xpath("//button")).getText().equals("Clicked")) {
            System.out.println("OK");
        }
        else System.out.println("NOT OK");

        driver.switchTo().window(mainTab);

    }
}
