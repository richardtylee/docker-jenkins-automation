import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// imports omitted
public class HeadlessTest {
  @Test
  public void testExecution() throws IOException {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

    // Add options to Google Chrome. The window-size is important for responsive sites
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    options.addArguments("no-sandbox");
    options.addArguments("disable-gpu");

    WebDriver driver = new ChromeDriver(options);
    driver.get("http://seleniumhq.org");
        
    // a guarantee that the test was really executed
    assertTrue(driver.findElement(By.id("q")).isDisplayed());

    driver.quit();
  }
}
