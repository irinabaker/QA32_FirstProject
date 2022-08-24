import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumLocators {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro-1578153671498.web.app/registration?url=%2Fsearch");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void startFindLocators() {
        //id
        driver.findElement(By.id("name"));
        //className
        driver.findElement(By.className("input-container"));
        //name
        driver.findElement(By.name("viewport"));
        //linkText
        WebElement car = driver.findElement(By.linkText("Let the car work"));
        System.out.println(car.getText());
        //partialLinkText
        WebElement car1 = driver.findElement(By.partialLinkText("car"));
        System.out.println(car1.getText());
    }

    @Test
    public void startFindCss() {
        //tagName ->
        //driver.findElement(By.tagName("label"));
        driver.findElement(By.cssSelector("label"));
        //id -> #
        //driver.findElement(By.id("name"));
        driver.findElement(By.cssSelector("#name"));
        //className -> .
        //driver.findElement(By.className("login-registration-container"));
        driver.findElement(By.cssSelector(".login-registration-container"));
        //attribute -> []
        //driver.findElement(By.name("viewport"));
        //driver.findElement(By.cssSelector("[name='viewport']"));
        driver.findElement(By.cssSelector("[autocomplete='name']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        //contains -> ("ssw")
        driver.findElement(By.cssSelector("[for*='ssw']"));
        //start with "pas" -> ^
        driver.findElement(By.cssSelector("[for^='pas']"));
        //end on "rd" -> $
        driver.findElement(By.cssSelector("[for$='rd']"));
        //tag + class
        driver.findElement(By.cssSelector("label.input-label"));
        //tag + class + para
        driver.findElement(By.cssSelector("label.input-label[for='name']"));
    }

    @Test
    public void startFindByXpath() {
        // "//*[@att='value']
        //tagName -> "//tag"
        //driver.findElement(By.tagName("label"));
        driver.findElement(By.xpath("//label"));
        //id -> "//tag[@id='value']
        //driver.findElement(By.id("name"));
        driver.findElement(By.xpath("//input[@id='name']"));
        //className -> "//tag[@class='value']
        //driver.findElement(By.className("login-registration-container"));
        driver.findElement(By.xpath("//div[@class='login-registration-container']"));
        //attribute
        driver.findElement(By.xpath("//*[@autocomplete='name']"));
        //contains -> ("ssw")
       // driver.findElement(By.cssSelector("[for*='ssw']"));
        driver.findElement(By.xpath("//*[contains(.,'ssw')]"));
        driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]"));
    }

    @AfterMethod
    public void tearDawn() {
        driver.quit();

    }
}
