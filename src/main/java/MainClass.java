import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuzmin_ad\\QA_Auto\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//div[@class='CheckboxCaptcha-Anchor']")).click(); //captcha check
        driver.findElement(By.xpath("//div[@data-zone-name='category-link'][3]/div")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные и сушильные машины']")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();

        selectCheckbox("ATLANT");

        System.out.println(driver.findElement(By.xpath("//input[contains(@name, 'ATLANT')]")).isSelected());

        selectCheckbox("Bosch");
        selectCheckbox("LG");

        unselectCheckbox("Bosch");

        driver.findElement(By.xpath("//span[contains(text(), 'Доставка курьером')]")).click();
        System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'До 5 дней')]/parent::div/preceding-sibling::input")).isSelected());
        driver.findElement(By.xpath("//span[contains(text(), 'До 5 дней')]")).click();
        System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'До 5 дней')]/parent::div/preceding-sibling::input")).isSelected());

//        driver.quit();

    }

    public static void selectCheckbox (String name) {
        String checkXpath = "//span[contains(text(), '%s')]";
        String checkXpathIfChecked = "//input[contains(@name, '%s')]";
        if (!driver.findElement(By.xpath(String.format(checkXpathIfChecked, name))).isSelected()) {
            driver.findElement(By.xpath(String.format(checkXpath, name))).click();
        }
    }

    public static void unselectCheckbox (String name) {
        String checkXpath = "//span[contains(text(), '%s')]";
        String checkXpathIfChecked = "//input[contains(@name, '%s')]";
        if (driver.findElement(By.xpath(String.format(checkXpathIfChecked, name))).isSelected()) {
            driver.findElement(By.xpath(String.format(checkXpath, name))).click();
        }
    }
}
