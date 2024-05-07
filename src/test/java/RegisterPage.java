import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
  @Before
    public void setUp(){
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://www.instagram.com/");
  }
  @Test
    public void RegisterPageTest(){
    WebElement kaydol = driver.findElement(By.linkText("Kaydol"));
    kaydol.click();
    Actions actions = new Actions(driver);


    Faker faker = new Faker();
    String mail = faker.internet().emailAddress();
            actions.sendKeys(mail).sendKeys(Keys.TAB)
                    .sendKeys(faker.name().fullName()).sendKeys(Keys.TAB)
                    .sendKeys(faker.name().username()).sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB).
                    sendKeys(Keys.ENTER).perform();


  }
}
