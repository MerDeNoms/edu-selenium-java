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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        driver.get("https://dineshvelhal.github.io/testautomation-playground/expected_conditions.html");

        List<WebElement> button = driver.findElements(By.xpath("//button[@id='visibility']"));

        if (button.size() == 0) System.out.println("No such element!");
        else System.out.println("Element is found!");

        driver.quit();

    }
}
