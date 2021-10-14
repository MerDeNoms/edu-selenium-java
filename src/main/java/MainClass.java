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

        driver.get("https://dineshvelhal.github.io/testautomation-playground/keyboard_events.html");

        String someKeys = Keys.chord("Hello World!");
        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String copy = Keys.chord(Keys.CONTROL, "c");
        String paste = Keys.chord(Keys.CONTROL, "v");

        WebElement textArea = driver.findElement(By.xpath("//textarea"));
        textArea.sendKeys(someKeys);
        textArea.sendKeys(select);
        textArea.sendKeys(Keys.ARROW_RIGHT, Keys.SPACE);
        textArea.sendKeys(copy);
        textArea.sendKeys(paste);

    }
}
